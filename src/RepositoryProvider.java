import com.google.gson.Gson;

import java.util.List;

public class RepositoryProvider implements IProvider {

    private List<Gson> data;

    // deserialize json to object string
    private static String jsonInString = "{\"id\":\"1\"}";

    public String getData(int id) {
        IEntity entity;
        for (Gson curGson : data) {
            entity = curGson.fromJson(jsonInString, IEntity.class);
            if (entity.getId() == id) {
                return curGson.toJson(entity);
            }
        }
        return null;
    }

    public List<Gson> getAll() {
        return data;
    }

    public void add(String entity) throws Exception {
        Gson g = new Gson();
        g.fromJson(entity,IEntity.class);
        this.data.add(g);
    }

    public void update(int id , String entity) throws Exception {
        boolean found = false;
        for (int i = 0; i < this.data.size(); i++) {
            if (id == data.get(i).fromJson(jsonInString, IEntity.class).getId()) {

                Gson g = new Gson();
                g.fromJson(entity,IEntity.class);
                data.remove(i);
                data.add(i, g);
                found = true;
                break;
            }
        }
        if (!found) throw new Exception("the entity object with current id wasn't found");
    }

    public void remove(int id) throws Exception {
        boolean found = false;
        for (int i = 0; i < this.data.size(); i++) {
            // finding the entity we are updating
            if (id == data.get(i).fromJson(jsonInString, IEntity.class).getId()) {
                data.remove(i);
                found = true;
                break;
            }
        }
        if (!found) throw new Exception("the entity object with current id wasn't found");
    }
}