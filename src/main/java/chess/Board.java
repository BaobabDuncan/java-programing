package chess;

import pieces.Piece;

import java.util.ArrayList;

import static util.StringUtil.NEWLINE;

/**
 * Created by Administrator on 2017-02-02.
 */
public class Board {

    private ArrayList<ArrayList<Piece>> pieces = new ArrayList<ArrayList<Piece>>();

    public Board() {
        this.initialize();
    }

    private void initialize() {
        Piece.resetCount();
        for (int i=0; i < 8; i++){
            pieces.add(new ArrayList<Piece>());
        }
        pieces.set(0, createWhiteQueenRank());
        pieces.set(1, createWhitePawnRank());
        pieces.set(6, createBlackPawnRank());
        pieces.set(7, createBlackQueenRank());
    }

    private ArrayList<Piece> createWhiteQueenRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());
        return rank;
    }

    private ArrayList<Piece> createWhitePawnRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        rank.add(Piece.createWhitePawn());
        return rank;
    }

    private ArrayList<Piece> createBlackPawnRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        rank.add(Piece.createBlackPawn());
        return rank;
    }

    private ArrayList<Piece> createBlackQueenRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());
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

    public String getRank(int rank) {
        if (pieces.get(rank-1).size()==0) {
            return "........";
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<8; i++) {
            builder.append(pieces.get(rank-1).get(i).getRepresentation());
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


    public int getNumberOfPiece(Piece.Color color, Piece.Type type) {
        int result = 0;
        for (ArrayList<Piece> innerPieces: pieces){
            for (int i = 0; i < innerPieces.size(); i++){
                Piece piece = innerPieces.get(i);
                if (piece.getColor() == color && piece.getType() == type){
                    result++;
                }
            }
        }
        return result;
    }

    public char getPiece(String coordinate) {
        Point point = this.getPointToXY(coordinate);
        return pieces.get(point.getY()).get(point.getX()).getRepresentation();
    }

    public void reset() {
        Piece.resetCount();
        pieces.clear();
        for (int i=0; i < 8; i++){
            pieces.add(new ArrayList<Piece>());
        }
    }

    public void addPiece(Piece piece, String coordinate) {
        Point point = this.getPointToXY(coordinate);
        ArrayList<Piece> rank = pieces.get(point.getY());
        System.out.println(rank);
        System.out.println(point.getX());
        rank.set(point.getX(), piece);
    }

    private Point getPointToXY(String coordinate) {
        int x = Character.getNumericValue(coordinate.substring(0,1).charAt(0)) - 9;
        int y = Integer.parseInt(coordinate.substring(1, 2));
        Point point = new Point(x - 1, y - 1);
        return point;
    }
}
