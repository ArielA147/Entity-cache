import com.google.gson.Gson;

import java.util.List;

public interface IProvider {

    public Gson getData(int id);
    public List<Gson> getAll();

    public void add (Gson gson);
    public void update (Gson gson);
    public void remove (Gson gson);


}
