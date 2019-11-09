import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

public class User<T extends IEntity> implements Observer {

    private ConcurrentHashMap<Integer, T> data;
    private EntityCache<T> myCache;

    public User(T entity) {
        this.data = new ConcurrentHashMap<>();
        this.data.put(entity.getId(), entity);
    }

    public void add(T entity) {
        try {
            myCache.add(entity);
            this.data.put(entity.getId(), entity);
        } catch (Exception e) {
            System.out.println("the adding function didn't succeed ");
        }
    }

    public void update(T entity) {
        try {
            myCache.update(entity);
            this.data.replace(entity.getId(), entity);
        } catch (Exception e) {
            System.out.println("the update function didn't succeed ");
        }

    }

    public void remove(int id) {
        try {
            myCache.remove(id);
            this.data.remove(id);
        } catch (Exception e) {
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
