package chess;

import junit.framework.TestCase;
import pieces.Piece;

import static util.StringUtil.NEWLINE;

/**
 * Created by Administrator on 2017-02-02.
 */
public class BoardTest extends TestCase {
    private Board board;

    public void setUp() {
        board = new Board();
    }

    public void testNumberOfPieces() {
        assertEquals(32, board.getNumberOfPieces());
        assertEquals(16, board.getNumberOfWhitePieces());
        assertEquals(16, board.getNumberOfBlackPieces());
    }

    public void testRanks() {
        assertEquals("rnbqkbnr", board.getRank(1));
        assertEquals("pppppppp", board.getRank(2));
        assertEquals("PPPPPPPP", board.getRank(7));
        assertEquals("RNBQKBNR", board.getRank(8));
    }

    public void testFullBoard() {
        assertEquals(
                "RNBQKBNR" + NEWLINE +
                "PPPPPPPP" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "pppppppp" + NEWLINE +
                "rnbqkbnr" + NEWLINE
                ,
                board.print()
        );
    }

    public void testCalculateNumberOfRank(){
        assertEquals(8, board.getNumberOfPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        assertEquals(1, board.getNumberOfPiece(Piece.Color.WHITE, Piece.Type.KING));
        assertEquals(2, board.getNumberOfPiece(Piece.Color.BLACK, Piece.Type.KNIGHT));
    }

    public void testGetRank(){
        assertEquals('r', board.getPiece("a1"));
        assertEquals('k', board.getPiece("e1"));
        assertEquals('r', board.getPiece("h1"));
        assertEquals('K', board.getPiece("e8"));
    }

    public void testAddPiece(){
        board.reset();
//        board.addPiece(Piece.createBlackPawn(), "a1");
    }

}
