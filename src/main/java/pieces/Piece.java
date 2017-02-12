package pieces;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Piece {
    public static final String COLOR_WHITE = "COLOR_WHITE";
    public static final String COLOR_BLACK = "COLOR_BLACK";

    public final static String TYPE_PAWN = "p";
    public final static String TYPE_KNIGHT = "n";
    public final static String TYPE_ROOK = "r";
    public final static String TYPE_KING = "k";
    public final static String TYPE_QUEEN = "q";
    public final static String TYPE_BISHOP = "b";

    private String color;
    private String type;

    private static int whitePiecesInUse = 0;
    private static int blackPiecesInUse = 0;

    private Piece(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public static Piece create(String color, String type) {
        if (color.equals(COLOR_WHITE)){
            whitePiecesInUse++;
        } else{
            blackPiecesInUse++;
        }
        return new Piece(color, type);
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

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        if (this.isWhite()){
            return type.toUpperCase();
        }
        return type;
    }

    public boolean isBlack() {
        return this.color.equals(COLOR_BLACK);
    }

    public boolean isWhite() {
        return this.color.equals(COLOR_WHITE);
    }
}
