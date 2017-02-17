package exercise;

import junit.framework.TestSuite;

/**
 * Created by sanguk on 16/02/2017.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTest(exercise.chess.AllTests.suite());
        suite.addTest(exercise.pieces.AllTests.suite());
        return suite;
    }
}
