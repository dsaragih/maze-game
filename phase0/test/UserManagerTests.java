import org.junit.*;

import java.util.Date;

import static org.junit.Assert.*;

public class UserManagerTests {

    private final UserManager UserManager = new UserManager();
    @Test(timeout = 50)
    public void testLoginNonAdmin(){
        UserManager.addUser("Alice", "AlicePass", false);
        assertNotNull("Was unable to add non-admin user",
                UserManager.login("Alice", "AlicePass"));
    }
    @Test(timeout = 50)
    public void testLoginAdmin(){
        UserManager.addUser("Alice", "AlicePass", true);
        assertNotNull("Was unable to add non-admin user",
                UserManager.login("Alice", "AlicePass"));
    }
    @Test(timeout = 50)
    public void testLoginInvalidUser() {
        assertNull(UserManager.login("Charlie the Ugly Duckling", "Quack"));
    }

    @Test(timeout = 50)
    public void testDeleteUser(){
        UserManager.addUser("Bob the Vanquished", "BobPass", false);
        UserManager.delete("Bob the Vanquished");
        assertFalse(UserManager.getUsers().containsKey("Bob the Vanquished"));
    }

    @Test(timeout = 200)
    public void testSuspendUser(){
        // For some reason this test takes longer than 50ms
        UserManager.addUser("Bob the Banned", "BobPass", false);
        UserManager.ban("Bob the Banned");
        assertTrue(UserManager.getBannedUsers().contains("Bob the Banned"));
    }
}
