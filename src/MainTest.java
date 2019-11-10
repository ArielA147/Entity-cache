import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainTest {


    @BeforeAll
    public void setup() {

    }


    @Test
    public void somethingTest() {
        RepositoryProvider repo = new RepositoryProvider();
        EntityCache<Cat> cache = new LocalCache(repo);
        User user1 = new User(repo,cache);

        cache.addObserver(user1);

        //assertEquals();
    }
}
