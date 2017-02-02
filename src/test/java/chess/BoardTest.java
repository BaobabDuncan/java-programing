package chess;

import junit.framework.TestCase;
import pieces.Pawn;

/**
 * Created by Administrator on 2017-02-02.
 */
public class BoardTest extends TestCase {
    private Board board;

    public void setUp(){
        board = new Board();
    }
    public void testCreate(){
        assertEquals(0, board.getNumberOfPawns());
    }

    public void testEnrollPawn(){
        Pawn whitePawn = new Pawn(Pawn.white);
        board.enroll(whitePawn);
        assertEquals(1, board.getNumberOfPawns());
        assertEquals(whitePawn, board.get(0));

        Pawn blackPawn = new Pawn(Pawn.black);
        board.enroll(blackPawn);
        assertEquals(2, board.getNumberOfPawns());
        assertEquals(blackPawn, board.get(1));
    }
}
