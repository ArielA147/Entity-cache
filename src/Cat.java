public class Cat implements IEntity {

    private int id;
    private String name;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
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
