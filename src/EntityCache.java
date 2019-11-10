import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * the class will optimize access to entities.
 */
public abstract class EntityCache<T extends IEntity> extends Observable {

    private IProvider provider;
    private ConcurrentHashMap<Integer, T> data;
    private static final Logger LOGGER = Logger.getLogger(EntityCache.class.getName());

    static enum LOADTYPE {
        LAZY,
        EAGER
    }

    ;

    private LOADTYPE loadType;


    public EntityCache(IProvider provider, LOADTYPE loadType) {
        this.provider = provider;
        this.data = new ConcurrentHashMap<Integer, T>();
        this.loadType = loadType;
        if (this.loadType == LOADTYPE.EAGER) {
            Map<Integer, String> tmp = provider.getAll();
        }

    }

    /**
     * loading the data from the provider to the local map if loadType is lazy
     *
     * @param loadType enum
     */
    private void loadData(LOADTYPE loadType) {
        if (loadType.equals(LOADTYPE.LAZY)) {
            for (Map.Entry<Integer, String> entry : provider.getAll().entrySet()) {
                GsonBuilder gson = new GsonBuilder();
                Type entityType = new TypeToken<T>(){}.getType();
                T entity= gson.create().fromJson(entry.getValue(), entityType);
                System.out.println(entity.getId());
                this.data.put(entry.getKey(),entity);
            }
        }
    }

    public T getEntity(int id) {
        try {
            return this.data.get(id);
        } catch (NullPointerException e) {
            System.out.println("could not get the entity from the provider, ");
            return null;
        }
    }

    /**
     * adding an entity to the cache and to the provider
     *
     * @param entity new data that represents an entity
     */
    public void add(T entity) {
        this.loadData(this.loadType);
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(entity);

            int id = entity.getId();

            this.provider.update(id, jsonString);
            this.data.put(id, entity);

            notifyObservers(entity);

        } catch (NullPointerException e) {
            System.out.println("could not add the new entity to the provider, hence the entity didn't get into your local cache");
        }
    }

    /**
     * update the value of an entity in the cache map and the provider data
     *
     * @param entity new data that represents an entity
     */
    public void update(T entity) {
        this.loadData(this.loadType);
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(entity);

            int id = entity.getId();

            this.provider.update(id, jsonString);
            this.data.replace(id, entity);
            notifyObservers(entity);

        } catch (NullPointerException e) {
            System.out.println("could not update the new entity to the provider, hence the entity didn't get into your entity cache");
        }
    }

    /**
     * the function removes from the cache (and provider) the entity with the given id number
     *
     * @param id int number
     */
    public void remove(int id) {

        this.loadData(this.loadType);

        try {
            provider.remove(id);
            data.remove(id);

            notifyObservers(id);

        } catch (NullPointerException e) {
            System.out.println("could not remove the entity from the provider, hence the entity didn't removed from your entity cache");
        }
    }

    public void addObserver(Observer o) {
        super.addObserver(o);
    }

    public void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    public static void main(String[] args){
        return;
    }
}
