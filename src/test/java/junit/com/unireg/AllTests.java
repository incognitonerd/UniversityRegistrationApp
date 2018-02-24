package junit.com.unireg;
import junit.com.unireg.model.entities.StudentTest;
import junit.com.unireg.model.entities.UniversityTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite(){
		TestSuite ts = new TestSuite();
		ts.addTestSuite(StudentTest.class);
		ts.addTestSuite(UniversityTest.class);
		return ts;
	}
}
