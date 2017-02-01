import junit.framework.TestCase;

/**
 * Created by Administrator on 2017-02-01.
 */
public class PawnTest extends TestCase {
    public void testCreate(){
        final String whiteColor = "white";
        final String blackColor = "black";

        Pawn firstPawn = new Pawn(whiteColor);
        assertEquals(whiteColor, firstPawn.getColor());

        Pawn secondPawn = new Pawn(blackColor);
        assertEquals(blackColor, secondPawn.getColor());

    }
}
