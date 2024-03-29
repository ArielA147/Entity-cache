import java.security.KeyException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

public class User<T extends IEntity> implements Observer {

    private ConcurrentHashMap<Integer, T> data;
    private EntityCache<T> myCache;

    public User(IProvider provider, EntityCache<T> entityCache) {
        this.data = new ConcurrentHashMap<Integer, T>();
        this.myCache = entityCache;
    }

    public void add(T entity) {
        try {
            if(this.data.containsKey(entity.getId())) throw new KeyException("the entity is already exist");
            this.data.put(entity.getId(), entity);

            myCache.add(entity);
        } catch (KeyException e) {
            System.out.println(e.getMessage());
            System.out.println("could not add the new entity to the provider");
        }
    }

    public void update(T entity) {
        try {
            myCache.update(entity);
            this.data.replace(entity.getId(), entity);
        } catch (NullPointerException e) {
            System.out.println("the update function didn't succeed ");
            System.out.println("could not update the new entity to the provider, hence the entity didn't get into your entity cache");
        }
    }

    public void remove(int id) {
        try {
            myCache.remove(id);
            this.data.remove(id);
        } catch (NullPointerException e) {
            System.out.println("could not remove the entity from the provider, hence the entity didn't removed from your entity cache");
            System.out.println("the removing function didn't succeed ");
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        /**
         * here the user will implement the function as he wants to
         */
    }
}
