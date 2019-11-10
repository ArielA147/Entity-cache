/**
 *
 */
public class LocalCache extends EntityCache {
    public LocalCache(IProvider provider) {
        super(provider);
    }

    public LocalCache(IProvider provider, EntityCache.LOADTYPE loadType) {
        super(provider, loadType);
    }
}
