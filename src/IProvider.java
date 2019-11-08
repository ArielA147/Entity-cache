import com.google.gson.Gson;

public interface IProvider {

    public Gson getData(int id);
    public Gson getAll();

    public void add (Gson gson);
    public void update (Gson gson);
    public void remove (Gson gson);


}
