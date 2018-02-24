package junit.com.universityregistration.model.entities;
import junit.framework.TestCase;
import org.junit.Test;
import com.universityregistration.model.entities.University;
import com.universityregistration.utils.Constants;

public class UniversityTest extends TestCase {
	@Test
	public void testSetId(){
		University u = new University();
		u.setId(Integer.valueOf(Constants.ID_TESTER.getStr()));
		assertEquals(Integer.valueOf(Constants.ID_TESTER.getStr()), u.getId());
	}
	
	@Test
	public void testSetName(){
		University u = new University();
		u.setName(Constants.NAME_TESTER.getStr());
		assertEquals(Constants.NAME_TESTER.getStr(), u.getName());
	}
	
	@Test
	public void testSetCity(){
		University u = new University();
		u.setCity(Constants.CITY_TESTER.getStr());
		assertEquals(Constants.CITY_TESTER.getStr(), u.getCity());
	}
	
	@Test
	public void testSetCountry(){
		University u = new University();
		u.setCountry(Constants.COUNTRY_TESTER.getStr());
		assertEquals(Constants.COUNTRY_TESTER.getStr(), u.getCountry());
	}
}
