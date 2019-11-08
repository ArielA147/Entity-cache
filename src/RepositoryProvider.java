import com.google.gson.Gson;

import java.util.List;

public class RepositoryProvider implements IProvider {

    private List<Gson> data;
    private String jsonInString = "{\"id\":\"1\"}";

    public Gson getData(int id) {
        MyEntity entity;
        for (Gson curGson : data) {
            entity = curGson.fromJson(jsonInString, MyEntity.class);
            if (entity.getId() == id) {
                return curGson;
            }
        }
        return null;
    }
    public List<Gson> getAll() {
        return data;
    }
    public void add(Gson entity) throws Exception {
        this.data.add(entity);
    }
    public void update(Gson entity) throws Exception {
        int entityId = entity.fromJson(jsonInString, MyEntity.class).getId();
        for (int i = 0; i < this.data.size(); i++) {
            // finding the entity we are updating
            if (entityId == data.get(i).fromJson(jsonInString, MyEntity.class).getId()) {
                data.add(i, entity);
                break;
            }
        }
    }e
    public void remove(Gson entity) throws Exception {
        int entityId = entity.fromJson(jsonInString, MyEntity.class).getId();
        for (int i = 0; i < this.data.size(); i++) {
            // finding the entity we are updating
            if (entityId == data.get(i).fromJson(jsonInString, MyEntity.class).getId()) {
                data.remove(i);
                break;
            }
        }
    }
}