import com.google.gson.Gson;

import java.util.List;

public interface IProvider {
    public String getData(int id);
    public List<Gson> getAll();

    public void add (String entity) throws Exception;
    public void update (int id ,String entity) throws Exception;
    public void remove (int id) throws Exception;

}
