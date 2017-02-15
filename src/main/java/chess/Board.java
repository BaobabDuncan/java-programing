package chess;

import pieces.Piece;

import java.util.ArrayList;
import static util.StringUtil.NEWLINE;

/**
 * Created by Administrator on 2017-02-02.
 */
public class Board {

    ArrayList<ArrayList<Piece>> pieces = new ArrayList<ArrayList<Piece>>();

    public void Board(){
        initialize();
    }

    public void initialize() {
//        Piece.resetCount();
//
//        for (int i=0; i < 8; i++){
//            pieces.add(new ArrayList<Piece>());
//        }
//        pieces.set(0, createQueenRank(Piece.Color.WHITE));
//        pieces.set(1, createPawnRank(Piece.Color.WHITE));
//        pieces.set(6, createPawnRank(Piece.Color.BLACK));
//        pieces.set(7, createQueenRank(Piece.Color.BLACK));
    }

    private ArrayList<Piece> createPawnRank(Piece.Color colour) {
        ArrayList<Piece> rank = new ArrayList<Piece>();
//        for (int i=0; i<8; i++) {
//            rank.add(Piece.create(colour, Piece.TYPE_PAWN));
//        }
        return rank;
    }

    private ArrayList<Piece> createQueenRank(Piece.Color colour) {
        ArrayList<Piece> rank = new ArrayList<Piece>();
//        rank.add(Piece.create(colour, Piece.TYPE_ROOK));
//        rank.add(Piece.create(colour, Piece.TYPE_KNIGHT));
//        rank.add(Piece.create(colour, Piece.TYPE_BISHOP));
//        rank.add(Piece.create(colour, Piece.TYPE_QUEEN));
//        rank.add(Piece.create(colour, Piece.TYPE_KING));
//        rank.add(Piece.create(colour, Piece.TYPE_BISHOP));
//        rank.add(Piece.create(colour, Piece.TYPE_KNIGHT));
//        rank.add(Piece.create(colour, Piece.TYPE_ROOK));
        return rank;
    }

    public int getNumberOfPieces() {
        return Piece.getPiecesInUse();
    }

    public int getNumberOfWhitePieces() {
        return Piece.getNumberOfWhitePieces();
    }

    public int getNumberOfBlackPieces() {
        return Piece.getNumberOfBlackPieces();
    }

    public ArrayList<ArrayList<Piece>> getPieces() {
        return pieces;
    }

    public String getRank(int rank) {
        if (pieces.get(rank-1).size()==0) {
            return "........";
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<8; i++) {
            builder.append(pieces.get(rank-1).get(i));
        }
        return builder.toString();
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int i=8; i>0; i--) {
            builder.append(getRank(i));
            builder.append(NEWLINE);
        }
        return builder.toString();
    }



}
