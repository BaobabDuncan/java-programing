package sis;

import junit.framework.TestSuite;

/**
 * Created by Administrator on 2017-02-06.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(sis.report.AllTests.suite());
        suite.addTest(sis.studentinfo.AllTests.suite());
        return suite;
    }
}
