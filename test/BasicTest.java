import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        // Create a new user and save it
        new MyUser("admin@gmail.com", "123", "admin", true).save();
        new MyUser("user@gmail.com", "321", "user", false).save();

        MyUser admin = User.find("byEmail", "admin@gmail.com").first();
        MyUser user = User.find("byEmail", "user@gmail.com").first();

        // Test
        assertNotNull(admin);
        assertEquals("admin", admin.fullname);

        assertNotNull(user);
        assertEquals("user", user.fullname);
    }
}
