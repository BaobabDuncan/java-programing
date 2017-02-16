package pieces;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Piece {

    public enum Color {WHITE, BLACK}
    public enum Type {ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN}

    static final char PAWN_REPRESENTATION = 'p';
    static final char ROOK_REPRESENTATION = 'r';
    static final char KNIGHT_REPRESENTATION = 'n';
    static final char BISHOP_REPRESENTATION = 'b';
    static final char QUEEN_REPRESENTATION = 'q';
    static final char KING_REPRESENTATION = 'k';

    private Color color;
    private Type type;
    private char representation;

    private static int whitePiecesInUse = 0;
    private static int blackPiecesInUse = 0;

    private Piece(Color color, Type type, char representation) {
        this.color = color;
        this.type = type;
        this.representation = representation;
        if (color == Color.WHITE){
            whitePiecesInUse++;
        } else if (color == Color.BLACK){
            blackPiecesInUse++;
        }
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN, PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN, PAWN_REPRESENTATION);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK, ROOK_REPRESENTATION);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK, ROOK_REPRESENTATION);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT, KNIGHT_REPRESENTATION);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT, KNIGHT_REPRESENTATION);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP, BISHOP_REPRESENTATION);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP, BISHOP_REPRESENTATION);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN, QUEEN_REPRESENTATION);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN, QUEEN_REPRESENTATION);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING, KING_REPRESENTATION);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING, KING_REPRESENTATION);
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
        if (this.isBlack()) return Character.toUpperCase(representation);
        return representation;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }
}
