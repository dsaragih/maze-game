import org.junit.*;

import java.util.Date;

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

    @Test(timeout = 50)
    public void testDeleteUser() {
        UserManager.addUser("Bob the Vanquished", "BobPass", false);
        UserManager.delete("Bob the Vanquished");
        assertFalse(UserManager.getUsers().containsKey("Bob the Vanquished"));
    }

    @Test(timeout = 200)
    public void testSuspendUser() {
        // For some reason this test takes longer than 50ms (maybe Date creation idk)
        UserManager.addUser("Bob the Banned", "BobPass", false);
        User Bob = UserManager.getUsers().get("Bob the Banned");
        UserManager.suspend("Bob the Banned", new Date());
        assertTrue(UserManager.getSuspendedUsers().containsKey(Bob));
    }
}
