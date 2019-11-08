import com.google.gson.Gson;

import java.util.List;

public interface IProvider {
    public Gson getData(int id);
    public List<Gson> getAll();

    public void add (Gson entity) throws Exception;
    public void update (Gson entity) throws Exception;
    public void remove (Gson entity) throws Exception;

}
