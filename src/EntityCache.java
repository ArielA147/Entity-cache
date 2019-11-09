import com.google.gson.Gson;

import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * the class will optimize access to entities.
 */
public abstract class EntityCache<T extends IEntity> extends Observable {

    private IProvider provider;
    private ConcurrentHashMap<Integer, T> data;

    enum loadType {
        Lazy,
        Eager
    };

    public T getEntity(int id) {
        try {
            return this.data.get(id);
        } catch (Exception e) {
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

        } catch (Exception e) {
            Logger.log("could not add the new entity to the provider, hence the entity didnt get into your " +
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

        } catch (Exception e) {
            System.out.println("could not update the new entity to the provider, hence the entity didnt updated into " +
                    "your local cache");
        }
    }

    public void remove(int id) {
        try {
            provider.remove(id);
            data.remove(id);
        } catch (Exception e) {
            System.out.println("could not add the new entity to the provider, hence the entity didnt get into " +
                    "your local cache");
        }
    }

}
