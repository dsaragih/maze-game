import org.junit.*;
import static org.junit.Assert.*;

public class UserManagerTests {

    @Test(timeout = 50)
    public void testLoginNonAdmin() {
        UserManager.addUser("Alice", "AlicePass", false);
        assertNotNull("Was unable to add non-admin user",
                UserManager.login("Alice", "AlicePass"));
    }
    @Test(timeout = 50)
    public void testLoginAdmin() {
        UserManager.addUser("Alice", "AlicePass", true);
        assertNotNull("Was unable to add non-admin user",
                UserManager.login("Alice", "AlicePass"));
    }
    @Test(timeout = 50)
    public void testLoginInvalidUser() {
        assertNull(UserManager.login("Charlie the Ugly Duckling", "Quack"));
    }
}
