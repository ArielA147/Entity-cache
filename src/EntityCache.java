import com.google.gson.Gson; // in order to create a Json format

import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * the class will optimize access to entities.
 */
public abstract class EntityCache<T extends IEntity> extends Observable {

    private IProvider provider;
    private ConcurrentHashMap<Integer, T> data;

    static enum LOADTYPE {
        LAZY,
        EAGER
    }

    ;

    public EntityCache(IProvider provider, LOADTYPE loadType) {
        this.provider = provider;
        this.data = new ConcurrentHashMap<Integer, T>();
        switch (loadType) {
            case EAGER:
                Map<Integer, String> tmp = provider.getAll();

                break;
            case LAZY:
                break;
        }

    }


    public T getEntity(int id) {
        try {
            return this.data.get(id);
        } catch (NullPointerException e) {
            System.out.println("there is not entity in this id number");
            return null;
        }
    }

    public void add(T entity) {
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(entity);

            int id = entity.getId();

            this.provider.update(id, jsonString);
            this.data.put(id, entity);

            notifyObservers(entity);

        } catch (NullPointerException e) {
            System.out.println("could not add the new entity to the provider, hence the entity didnt get into your " +
                    "local cache");
        }
    }

    public void update(T entity) {
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(entity);

            int id = entity.getId();

            this.provider.update(id, jsonString);
            this.data.replace(id, entity);
            notifyObservers(entity);

        } catch (NullPointerException e) {
            System.out.println("could not update the new entity to the provider, hence the entity didn't updated " +
                    "into your local cache");
        }
    }

    public void remove(int id) {
        try {
            provider.remove(id);
            data.remove(id);

            notifyObservers(id);

        } catch (NullPointerException e) {
            System.out.println("could not add the new entity to the provider, hence the entity didnt get into " +
                    "your local cache");
        }
    }

    public void addObserver(Observer o) {
        super.addObserver(o);
    }

    public void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }
}
