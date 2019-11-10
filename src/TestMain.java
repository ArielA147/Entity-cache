public class TestMain {
    public static void main(String[] args) {

        RepositoryProvider repo = new RepositoryProvider();
        EntityCache<Cat> cache = new LocalCache(repo);
        User user1 = new User(repo,cache);
        User user2 = new User(repo,cache);
        cache.addObserver(user1);
        cache.addObserver(user2);

        Cat cat1 = new Cat(1, "mizi");
        Cat cat11 = new Cat(1, "lala");
        Cat cat2 = new Cat(2, "night");
        Cat cat3 = new Cat(3, "lilo");
        Cat cat4 = new Cat(6, "saten" );


        user1.add(cat1);

        // will add to the cache of user2 but will not add it to the cache and repository cause already exist
        user2.add(cat1);
        user2.add(cat3);
        user1.update(cat11);

        // will throw exception ,removing entity from cache Of user 1 which not exist in the user1 cache
        //user1.remove(cat3.getId());

        /* check removing an entity from user1 and the repository and the entity cache but not from user2 */
        user1.remove(cat1.getId()); // removing an entity from the cache
        user1.add(cat3); // adding the deleted entity to the user1 cache

        /* checking if wrong user action will throw an exception as excepted */

        user2.add(cat1); // will throw exception cause the entity already exist in the cache
        user1.add(cat2); // adding entity with id that is already exist
        user1.remove(99); // removing entity which is not exist
        user1.update(cat4); // update entity which not exist will raise an exception


    }
}