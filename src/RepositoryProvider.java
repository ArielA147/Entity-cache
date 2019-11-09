import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class RepositoryProvider implements IProvider {

    private Map<Integer, String> data;

    // deserialize json to object string
    private static String jsonInString = "{\"id\":\"1\"}";

    public String getData(int id) {
        return this.data.get(id);
    }

    public Map<Integer,String> getAll() {
        return this.data;
    }

    public void add(Integer id,String entity) throws Exception {
        this.data.put(id,entity);
    }

    public void update(int id , String entity) throws Exception {
        if(!this.data.containsKey(id)) throw new Exception("this id doesnt exsist");
        this.data.put(id,entity);
    }

    public void remove(int id) throws Exception {
        if(!this.data.containsKey(id)) throw new Exception("this id doesnt exsist");
        this.data.remove(id);
    }
}