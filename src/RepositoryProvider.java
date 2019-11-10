import java.security.KeyException;
import java.util.HashMap;
import java.util.Map;

public class RepositoryProvider implements IProvider {

    private Map<Integer, String> data;

    public RepositoryProvider() {
        this.data = new HashMap<Integer, String>();
    }

    public String getData(int id) {
        return this.data.get(id);
    }

    public Map<Integer, String> getAll() {
        return this.data;
    }

    public void add(Integer id, String entity) throws KeyException {
        if (this.data.containsKey(id))
            throw new KeyException("the id key already exists");
        this.data.put(id, entity);
    }

    public void update(int id, String entity) throws NullPointerException {
        if (!this.data.containsKey(id)) throw new NullPointerException("ID key was not exist");
        this.data.put(id, entity);
    }

    public void remove(int id) throws NullPointerException {
        if(getData(id).isEmpty()) throw new NullPointerException("the entity doesn't exists");
        this.data.remove(id);
    }
}