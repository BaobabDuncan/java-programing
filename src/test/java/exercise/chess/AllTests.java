package exercise.chess;

import junit.framework.TestSuite;

/**
 * Created by Administrator on 2017-02-02.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(BoardTest.class);
        return suite;
    }
}
