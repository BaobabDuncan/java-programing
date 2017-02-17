package sis.summer;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by Administrator on 2017-02-17.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(SummerCourseSessionTest.class);
        return suite;
    }
}
