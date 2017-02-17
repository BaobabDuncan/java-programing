package exercise.pieces;

import com.sun.jdi.InvalidTypeException;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Piece {

    static final char PAWN_REPRESENTATION = 'p';
    static final char ROOK_REPRESENTATION = 'r';
    static final char KNIGHT_REPRESENTATION = 'n';
    static final char BISHOP_REPRESENTATION = 'b';
    static final char QUEEN_REPRESENTATION = 'q';
    static final char KING_REPRESENTATION = 'k';
    static final char NO_PIECE_REPRESENTATION = '.';

    private final Color color;
    private final Type type;
    private double points = 0;

    public enum Color {WHITE, BLACK}
    public enum Type {ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN, NO_PIECE}

    static public Piece createWhite(Type type) {
        return new Piece(type, Color.WHITE);
    }

    static public Piece createBlack(Type type) {
        return new Piece(type, Color.BLACK);
    }

    static public Piece noPiece() {
        return new Piece(Piece.Type.NO_PIECE, null);
    }

    protected Piece(Type type, Color color) {
        this.color = color;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return (color != null && color.equals(Color.WHITE));
    }

    public boolean isBlack() {
        return (color != null && color.equals(Color.BLACK));
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public char getRepresentation() {
        char representation = '.';
        switch (this.type){
            case PAWN:
                representation = PAWN_REPRESENTATION;
                break;
            case ROOK:
                representation = ROOK_REPRESENTATION;
                break;
            case BISHOP:
                representation = BISHOP_REPRESENTATION;
                break;
            case KNIGHT:
                representation = KNIGHT_REPRESENTATION;
                break;
            case QUEEN:
                representation = QUEEN_REPRESENTATION;
                break;
            case KING:
                representation = KING_REPRESENTATION;
                break;
            case NO_PIECE:
                representation = NO_PIECE_REPRESENTATION;
                break;
        }
        if (this.isBlack()) representation = Character.toUpperCase(representation);
        return representation;
    }


}
