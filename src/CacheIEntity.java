import java.util.concurrent.ConcurrentHashMap;

public abstract class CacheIEntity<T> implements IEntity {

    IProvider provider;
    ConcurrentHashMap <Integer, T> data;

    public <T> CacheIEntity(Integer id);



}
