/**
 * represents the rules that an entity must have : set & get for the entity id and the json format of the object
 */
public interface IEntity {

    /**
     * @return the id number of the entity
     */
    public int getId();

    /**
     * @param number new number value of the id
     */
    public void setId(int number);

    /**
     * @return json string format of the entity class
     */
    public String stringJson();
}
