public class MyEntity implements IEntity {

    private int id;

    public MyEntity(int id){
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int number) {
        this.id = number;
    }
}
