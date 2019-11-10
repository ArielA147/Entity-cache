public class Main {
    public static void main(String[] args) {

        RepositoryProvider repo = new RepositoryProvider();
        EntityCache<Cat> cache = new LocalCache(repo);
        User user1 = new User(repo,cache);
        cache.addObserver(user1);

        Cat cat1 = new Cat(123, "mizi");
        Cat cat2 = new Cat(123, "night");
        Cat cat3 = new Cat(1235, "lilo");

        user1.add(cat1);
        user1.add(cat2);
        user1.add(cat3);

    }
}