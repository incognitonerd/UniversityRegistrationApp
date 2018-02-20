package junit.com.universityregistration;
import junit.com.universityregistration.model.entity.StudentTest;
import junit.com.universityregistration.model.entity.UniversityTest;
import junit.com.universityregistration.repository.addstudent.AddStudentRepositoryTest;
import junit.com.universityregistration.repository.addstudent.ShowAllStudentsRepositoryTest;
import junit.com.universityregistration.repository.removestudent.RemoveStudentRepositoryTest;
import junit.com.universityregistration.repository.university.AddUniversityRepositoryTest;
import junit.com.universityregistration.repository.university.ShowAllUniversitiesRepositoryTest;
import junit.com.universityregistration.repository.university.UniversityStatisticsRepositoryTest;
import junit.com.universityregistration.services.impl.AddStudentServiceImplTest;
import junit.com.universityregistration.services.impl.AddUniversityServiceImplTest;
import junit.com.universityregistration.services.impl.RemoveStudentServiceImplTest;
import junit.com.universityregistration.services.impl.ShowAllUniversitiesServiceImplTest;
import junit.com.universityregistration.services.impl.ShowStudentsServiceImplTest;
import junit.com.universityregistration.services.impl.UniversityStatsServiceImplTest;
import junit.com.universityregistration.ui.commons.UniversityLogoPanelLayoutFactoryTest;
import junit.com.universityregistration.ui.commons.UniversityMainUITest;
import junit.com.universityregistration.ui.commons.UniversityMenuLayoutFactoryTest;
import junit.com.universityregistration.ui.navigator.UniversityNavigatorTest;
import junit.com.universityregistration.ui.students.AddStudentMainLayoutFactoryTest;
import junit.com.universityregistration.ui.students.RemoveStudentLayoutFactoryTest;
import junit.com.universityregistration.ui.students.ShowAllStudentsLayoutFactoryTest;
import junit.com.universityregistration.ui.students.StudentLayoutFactoryTest;
import junit.com.universityregistration.ui.students.StudentSavedListenerTest;
import junit.com.universityregistration.ui.universities.AddUniversityLayoutFactoryTest;
import junit.com.universityregistration.ui.universities.ShowUniversityLayoutFactoryTest;
import junit.com.universityregistration.ui.universities.StatisticsUniversityLayoutFactoryTest;
import junit.com.universityregistration.ui.universities.UniversityLayoutFactoryTest;
import junit.com.universityregistration.ui.universities.UniversitySavedListenerTest;
import junit.com.universityregistration.ui.views.AbstractViewTest;
import junit.com.universityregistration.ui.views.UIComponentBuilderTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite(){
		TestSuite ts = new TestSuite();
		ts.addTestSuite(StudentTest.class);
		ts.addTestSuite(UniversityTest.class);
		//
		ts.addTestSuite(AddStudentRepositoryTest.class);
		ts.addTestSuite(ShowAllStudentsRepositoryTest.class);
		//
		ts.addTestSuite(RemoveStudentRepositoryTest.class);
		//
		ts.addTestSuite(AddUniversityRepositoryTest.class);
		ts.addTestSuite(ShowAllUniversitiesRepositoryTest.class);
		ts.addTestSuite(UniversityStatisticsRepositoryTest.class);
		//
		ts.addTestSuite(AddStudentServiceImplTest.class);
		ts.addTestSuite(AddUniversityServiceImplTest.class);
		ts.addTestSuite(RemoveStudentServiceImplTest.class);
		ts.addTestSuite(ShowAllUniversitiesServiceImplTest.class);
		ts.addTestSuite(ShowStudentsServiceImplTest.class);
		ts.addTestSuite(UniversityStatsServiceImplTest.class);
		//
		ts.addTestSuite(UniversityLogoPanelLayoutFactoryTest.class);
		ts.addTestSuite(UniversityMainUITest.class);
		ts.addTestSuite(UniversityMenuLayoutFactoryTest.class);
		//
		ts.addTestSuite(UniversityNavigatorTest.class);
		//
		ts.addTestSuite(AddStudentMainLayoutFactoryTest.class);
		ts.addTestSuite(RemoveStudentLayoutFactoryTest.class);
		ts.addTestSuite(ShowAllStudentsLayoutFactoryTest.class);
		ts.addTestSuite(StudentLayoutFactoryTest.class);
		ts.addTestSuite(StudentSavedListenerTest.class);
		//
		ts.addTestSuite(AddUniversityLayoutFactoryTest.class);
		ts.addTestSuite(ShowUniversityLayoutFactoryTest.class);
		ts.addTestSuite(StatisticsUniversityLayoutFactoryTest.class);
		ts.addTestSuite(UniversityLayoutFactoryTest.class);
		ts.addTestSuite(UniversitySavedListenerTest.class);
		//
		ts.addTestSuite(AbstractViewTest.class);
		ts.addTestSuite(UIComponentBuilderTest.class);
		return ts;
	}
}
