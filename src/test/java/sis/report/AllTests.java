package sis.report;

import junit.framework.TestSuite;

/**
 * Created by Administrator on 2017-02-06.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(CourseReportTest.class);
        return suite;
    }
}
