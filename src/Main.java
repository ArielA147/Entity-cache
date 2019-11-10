public class Main {
    public static void main(String[] args) {

        RepositoryProvider repo = new RepositoryProvider();
        EntityCache<Cat> cache = new LocalCache(repo);
        User user1 = new User(repo,cache);
        User user2 = new User(repo,cache);
        cache.addObserver(user1);
        cache.addObserver(user2);

        Cat cat1 = new Cat(123, "mizi");
        Cat cat2 = new Cat(123, "night");
        Cat cat3 = new Cat(1235, "lilo");
        Cat cat4 = new Cat(666, "saten" );


        user1.add(cat1);
        user2.add(cat3);
        user1.update(cat2);

        user1.remove(cat3.getId()); // removing entity from cache
        user1.add(cat3); // adding the deleted entity


        // checking if wrong user action will throw an exception as excepted
        user2.add(cat1); // will throw exception cause the entity already exist in the cache
        user1.add(cat2); // adding entity with id that is already exist
        user1.remove(99); // removing entity which is not exsists
        user1.update(cat4); // update entity which not exsit will raise an exception


    }
}