import java.util.Map;

/**
 * represents the provider action such as : adding, removing and update an entity in json format
 */
public interface IProvider {

    public String getData(int id);

    public Map<Integer, String> getAll();

    /**
     * adding a new entity to the map
     *
     * @param id     int number
     * @param entity data of the object in json format
     * @throws NullPointerException thrown when the id number doesn't
     */
    public void add(Integer id, String entity) throws NullPointerException;

    /**
     * updates the entity by the id number .
     *
     * @param id     int number
     * @param entity data of the object in json format
     * @throws NullPointerException thrown when the id number doesn't
     */
    public void update(int id, String entity) throws NullPointerException;

    /**
     * the function removes/delete the entity value from the concurrent provider by the id value
     *
     * @param id int number
     * @throws NullPointerException thrown when the id number doesn't exist
     */
    public void remove(int id) throws NullPointerException;

}
