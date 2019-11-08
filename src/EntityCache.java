import java.util.concurrent.ConcurrentHashMap;

public abstract class CacheEntity<T> implements IEntity {

    IProvider provider;
    ConcurrentHashMap <Integer, T> data;
    enum loadType {'Lazy', "Eager"};

    public T getEntity(int id){
        return data.get(id);
    }

    public abstract void add(Gson entity){}


}
