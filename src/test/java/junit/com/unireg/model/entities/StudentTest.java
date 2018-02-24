package junit.com.unireg.model.entities;
import junit.framework.TestCase;
import org.junit.Test;
import com.unireg.model.entities.Student;
import com.unireg.model.entities.University;
import com.unireg.utils.Constants;

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
		Student s = new Student();
		s.setUniversity(u);
		assertNotNull(s.getUniversity());
		assertTrue(s.getUniversity() instanceof University);
	}
}
