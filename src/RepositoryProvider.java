import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class RepositoryProvider implements IProvider {

    private Map<Integer, String> data;

    public RepositoryProvider(){
        this.data = new HashMap<Integer, String>();
    }

    public String getData(int id) {
        return this.data.get(id);
    }

    public Map<Integer,String> getAll() {
        return this.data;
    }

    public void add(Integer id,String entity) throws NullPointerException {
        this.data.put(id,entity);
    }

    public void update(int id , String entity) throws NullPointerException {
        if(!this.data.containsKey(id)) throw new NullPointerException("ID key was not exist");
        this.data.put(id,entity);
    }

    public void remove(int id) throws NullPointerException {
        this.data.remove(id);
    }
}