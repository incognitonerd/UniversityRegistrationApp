package junit.com.unireg.model.entities;
import junit.framework.TestCase;
import org.junit.Test;
import com.unireg.model.entities.User;
import com.unireg.utils.Constants;

public class UserTest extends TestCase {
	@Test
	public void testSetUsername(){
		User u = new User();
		u.setUsername(Constants.USERNAME_TESTER.getStr());
		assertEquals(Constants.USERNAME_TESTER.getStr(), u.getUsername());
	}
	
	@Test
	public void testSetPassword(){
		User u = new User();
		u.setPassword(Constants.PASSWORD_TESTER.getStr());
		assertEquals(Constants.PASSWORD_TESTER.getStr(), u.getPassword());
	}
}
