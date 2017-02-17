package exercise.pieces;

import junit.framework.TestSuite;

/**
 * Created by Administrator on 2017-02-02.
 */
public class AllTests {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(CharacterTest.class);
        return suite;
    }
}
