package junit.com.universityregistration;
import junit.com.universityregistration.model.entity.StudentTest;
import junit.com.universityregistration.model.entity.UniversityTest;
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
