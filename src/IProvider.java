import com.google.gson.Gson;

import java.util.Map;

public interface IProvider {

    public String getData(int id);
    public Map<Integer , String> getAll();

    public void add (Integer id ,String entity) throws Exception;
    public void update (int id , String entity) throws Exception;
    public void remove (int id) throws Exception;

}
