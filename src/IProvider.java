import java.util.Map;

public interface IProvider {

    public String getData(int id);
    public Map<Integer , String> getAll();

    public void add (Integer id ,String entity) throws NullPointerException;
    public void update (int id , String entity) throws NullPointerException;
    public void remove (int id) throws NullPointerException;

}
