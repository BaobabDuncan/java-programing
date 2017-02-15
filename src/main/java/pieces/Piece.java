package pieces;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Piece {

    public final static String TYPE_PAWN = "p";
    public final static String TYPE_KNIGHT = "n";
    public final static String TYPE_ROOK = "r";
    public final static String TYPE_KING = "k";
    public final static String TYPE_QUEEN = "q";
    public final static String TYPE_BISHOP = "b";




    public enum Color {WHITE, BLACK}
    enum Type {PAWN}
    static char PAWN_REPRESENTATION = 'p';

    private Color color;
    private Type type;

    private static int whitePiecesInUse = 0;
    private static int blackPiecesInUse = 0;



    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }

    public static void resetCount(){
        whitePiecesInUse = 0;
        blackPiecesInUse = 0;
    }

    public static int getPiecesInUse() {
        return whitePiecesInUse+blackPiecesInUse;
    }

    public static int getNumberOfWhitePieces() {
        return whitePiecesInUse;
    }

    public static int getNumberOfBlackPieces() {
        return blackPiecesInUse;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return 'a';
    }

//    public String toString() {
//        if (this.isWhite()){
//            return type.toUpperCase();
//        }
//        return type;
//    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }
}
