package pieces;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017-02-01.
 */
public class PieceTest extends TestCase {
    public void testCreate() {

        verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(), Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);

//        Piece pawn = Piece.create(
//                Piece.Color.WHITE,
//                Piece.TYPE_PAWN
//        );
//        assertEquals(Piece.Color.WHITE, pawn.getColor());
//
//        pawn = Piece.create(
//                Piece.Color.BLACK,
//                Piece.TYPE_PAWN
//        );
//        assertEquals(Piece.Color.BLACK, pawn.getColor());
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation){
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
//        assertEquals(representation, whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
//        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
    }

    public void testPrintable() {
//        Piece pawn = Piece.create(
//                Piece.Color.WHITE,
//                Piece.TYPE_PAWN
//        );
//        assertEquals("P", pawn.toString());
//
//        pawn = Piece.create(
//                Piece.Color.BLACK,
//                Piece.TYPE_PAWN
//        );;
//        assertEquals("p", pawn.toString());
    }

//    public void testIsWhite() {
//        assertTrue(Piece.create(Piece.Color.WHITE, Piece.TYPE_PAWN).isWhite());
//    }
//    public void testIsBlack() {
//        assertTrue(Piece.create(Piece.Color.BLACK, Piece.TYPE_PAWN).isBlack());
//    }
}
