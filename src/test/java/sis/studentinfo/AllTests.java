package sis.studentinfo;

import junit.framework.TestSuite;

/**
 * Created by Administrator on 2017-02-01.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(DateUtilTest.class);
        return suite;
    }
}
