package pieces;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017-02-01.
 */
public class PieceTest extends TestCase {
    public void testCreate() {
        Piece pawn = Piece.create(
                Piece.COLOR_WHITE,
                Piece.TYPE_PAWN
        );
        assertEquals(Piece.COLOR_WHITE, pawn.getColor());

        pawn = Piece.create(
                Piece.COLOR_BLACK,
                Piece.TYPE_PAWN
        );
        assertEquals(Piece.COLOR_BLACK, pawn.getColor());
    }

    public void testPrintable() {
        Piece pawn = Piece.create(
                Piece.COLOR_WHITE,
                Piece.TYPE_PAWN
        );
        assertEquals("P", pawn.toString());

        pawn = Piece.create(
                Piece.COLOR_BLACK,
                Piece.TYPE_PAWN
        );;
        assertEquals("p", pawn.toString());
    }

    public void testIsWhite() {
        assertTrue(Piece.create(Piece.COLOR_WHITE, Piece.TYPE_PAWN).isWhite());
    }
    public void testIsBlack() {
        assertTrue(Piece.create(Piece.COLOR_BLACK, Piece.TYPE_PAWN).isBlack());
    }
}
