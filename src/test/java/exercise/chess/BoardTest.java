package exercise.chess;

import junit.framework.TestCase;
import exercise.pieces.Piece;

import static util.StringUtil.appendNewLine;

/**
 * Created by Administrator on 2017-02-02.
 */
public class BoardTest extends TestCase {
    private Board board;

    public void setUp() {
        board = new Board();
    }

    public void testCreate(){
        board.initialize();
        assertEquals(32, board.getPiecesCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR")
                        + appendNewLine("PPPPPPPP")
                        + blankRank + blankRank + blankRank + blankRank
                        + appendNewLine("pppppppp")
                        + appendNewLine("rnbqkbnr"),
                board.print());
    }

    public void testGetPieceByPosition() {
        board.initialize();
        assertEquals('k', board.getPieceAt("e1").getRepresentation());
        assertEquals('p', board.getPieceAt("e2").getRepresentation());
        assertEquals('P', board.getPieceAt("e7").getRepresentation());
        assertEquals('K', board.getPieceAt("e8").getRepresentation());
        assertEquals('.', board.getPieceAt("e4").getRepresentation());

    }

    public void testCountPieces() {
        board.initialize();
        assertEquals(8, board.countPieces('P'));
        assertEquals(2, board.countPieces('R'));
        assertEquals(1, board.countPieces('k'));
    }

    public void testPlacePiecesOnEmptyBoard() {
        board = new Board();
        assertEquals(0, board.getPiecesCount());

        String position = "a2";
        Piece pawn = Piece.createWhite(Piece.Type.PAWN);
        board.put(pawn, position);
        assertEquals(pawn.getRepresentation(), board.getPieceAt(position).getRepresentation());
    }

}
