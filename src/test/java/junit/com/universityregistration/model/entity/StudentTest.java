package junit.com.universityregistration.model.entity;
import junit.framework.TestCase;
import org.junit.Test;
import com.universityregistration.model.entity.Student;
import com.universityregistration.model.entity.University;
import com.universityregistration.utils.Constants;

public class StudentTest extends TestCase {
	@Test
	public void testSetFirstName(){
		Student s = new Student();
		s.setFirstName(Constants.NAME_TESTER.getStr());
		assertEquals(Constants.NAME_TESTER.getStr(), s.getFirstName());
	}
	
	@Test
	public void testSetLastName(){
		Student s = new Student();
		s.setLastName(Constants.NAME_TESTER.getStr());
		assertEquals(Constants.NAME_TESTER.getStr(), s.getLastName());
	}
	
	@Test
	public void testSetAge(){
		Student s = new Student();
		s.setAge(Integer.valueOf(Constants.AGE_TESTER.getStr()));
		assertEquals(Integer.valueOf(Constants.AGE_TESTER.getStr()), s.getAge());
	}
	
	@Test
	public void testSetGender(){
		Student s = new Student();
		s.setGender(Constants.GENDER_TESTER.getStr());
		assertEquals(Constants.GENDER_TESTER.getStr(), s.getGender());
	}
	
	@Test
	public void testSetID(){
		Student s = new Student();
		s.setId(Integer.valueOf(Constants.ID_TESTER.getStr()));
		assertEquals(Integer.valueOf(Constants.ID_TESTER.getStr()), s.getId());
	}
	
	@Test
	public void testSetUniversity(){
		University u = new University();
		// u.setId(Integer.valueOf(Constants.ID_TESTER.getStr()));
		// u.setUniversityName(Constants.NAME_TESTER.getStr());
		// u.setUniversityCity(Constants.CITY_TESTER.getStr());
		// u.setUniversityCountry(Constants.COUNTRY_TESTER.getStr());
		Student s = new Student();
		s.setUniversity(u);
		assertNotNull(s.getUniversity());
		assertTrue(s.getUniversity() instanceof University);
	}
}
