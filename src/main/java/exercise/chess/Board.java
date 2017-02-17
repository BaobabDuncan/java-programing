package exercise.chess;

import exercise.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-02-02.
 */
public class Board {

    static final int PIECES_PER_RANK = 8;
    static final int RANKS_PER_BOARD = 8;

    private int piecesCount;
    private ArrayList<ArrayList<Piece>> table = new ArrayList<ArrayList<Piece>>(RANKS_PER_BOARD);

    public Board() {
        addEmptyRanks();
    }

    public void initialize() {
        addEmptyRanks();
        addWhiteFigureRank();
        addWhitePawnsRank();
        addBlackPawnsRank();
        addBlackFigureRank();
    }

    private void addWhiteFigureRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>(PIECES_PER_RANK);
        rank.add(Piece.createWhite(Piece.Type.ROOK));
        rank.add(Piece.createWhite(Piece.Type.KNIGHT));
        rank.add(Piece.createWhite(Piece.Type.BISHOP));
        rank.add(Piece.createWhite(Piece.Type.QUEEN));
        rank.add(Piece.createWhite(Piece.Type.KING));
        rank.add(Piece.createWhite(Piece.Type.BISHOP));
        rank.add(Piece.createWhite(Piece.Type.KNIGHT));
        rank.add(Piece.createWhite(Piece.Type.ROOK));
        piecesCount += PIECES_PER_RANK;
        table.set(0, rank);
    }

    private void addWhitePawnsRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>(PIECES_PER_RANK);
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        rank.add(Piece.createWhite(Piece.Type.PAWN));
        piecesCount += PIECES_PER_RANK;
        table.set(1, rank);
    }

    private void addBlackPawnsRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>(PIECES_PER_RANK);
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        rank.add(Piece.createBlack(Piece.Type.PAWN));
        piecesCount += PIECES_PER_RANK;
        table.set(RANKS_PER_BOARD - 2, rank);
    }

    private void addBlackFigureRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>(PIECES_PER_RANK);
        rank.add(Piece.createBlack(Piece.Type.ROOK));
        rank.add(Piece.createBlack(Piece.Type.KNIGHT));
        rank.add(Piece.createBlack(Piece.Type.BISHOP));
        rank.add(Piece.createBlack(Piece.Type.QUEEN));
        rank.add(Piece.createBlack(Piece.Type.KING));
        rank.add(Piece.createBlack(Piece.Type.BISHOP));
        rank.add(Piece.createBlack(Piece.Type.KNIGHT));
        rank.add(Piece.createBlack(Piece.Type.ROOK));
        piecesCount += PIECES_PER_RANK;
        table.set(RANKS_PER_BOARD - 1, rank);
    }


    private void addEmptyRanks() {
        piecesCount = 0;
        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            createEmptyRank();
        }
    }

    private void createEmptyRank() {
        ArrayList<Piece> newRank = new ArrayList<Piece>(PIECES_PER_RANK);
        for (int j = 0; j < PIECES_PER_RANK; j++)
            newRank.add(Piece.noPiece());
        table.add(newRank);
    }

    public int getPiecesCount() {
        return piecesCount;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = RANKS_PER_BOARD - 1; i >= 0; i--) {
            List<Piece> rank = table.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++)
                result.append(rank.get(j).getRepresentation());
            result.append(StringUtil.NEWLINE);
        }

        return result.toString();
    }

    public Piece getPieceAt(String position) {
        int rankNumber = -1;
        int fileNumber = -1;
        for (char value : position.toCharArray()) {
            if (Character.isDigit(value))
                rankNumber = Integer.parseInt("" + value) - 1;
            else if (Character.isLetter(value)) {
                fileNumber = charFileToInt(value);
            }
        }
        return table.get(rankNumber).get(fileNumber);
    }

    private int charFileToInt(char value) {
        if (value < 'a' || value > 'h')
            throw new InvalidPositionException();
        return value - 'a';
    }

    public int countPieces(char representation) {
        int count = 0;
        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            List<Piece> rank = table.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++)
                if (rank.get(j).getRepresentation() == representation)
                    count++;
        }
        return count;
    }

    public void put(Piece piece, String position) {
        int rankNumber = getRankFromPosition(position);
        int fileNumber = getFileFromPosition(position);
        table.get(rankNumber).set(fileNumber, piece);
    }

    private int getRankFromPosition(String position) {
        for (char value : position.toCharArray())
            if (Character.isDigit(value))
                return Integer.parseInt("" + value) - 1;

        throw new InvalidPositionException();
    }

    private int getFileFromPosition(String position) {
        for (char value : position.toCharArray())
            if (Character.isLetter(value))
                return charFileToInt(value);

        throw new InvalidPositionException();
    }

    private static class InvalidPositionException extends RuntimeException {

        public InvalidPositionException() {
        }
    }

//    private ArrayList<Piece> createWhiteQueenRank() {
//        ArrayList<Piece> rank = new ArrayList<Piece>();
//        rank.add(Piece.createWhiteRook());
//        rank.add(Piece.createWhiteKnight());
//        rank.add(Piece.createWhiteBishop());
//        rank.add(Piece.createWhiteQueen());
//        rank.add(Piece.createWhiteKing());
//        rank.add(Piece.createWhiteBishop());
//        rank.add(Piece.createWhiteKnight());
//        rank.add(Piece.createWhiteRook());
//        return rank;
//    }
//
//    private ArrayList<Piece> createWhitePawnRank() {
//        ArrayList<Piece> rank = new ArrayList<Piece>();
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        rank.add(Piece.createWhitePawn());
//        return rank;
//    }
//
//    private ArrayList<Piece> createBlackPawnRank() {
//        ArrayList<Piece> rank = new ArrayList<Piece>();
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        rank.add(Piece.createBlackPawn());
//        return rank;
//    }
//
//    private ArrayList<Piece> createBlackQueenRank() {
//        ArrayList<Piece> rank = new ArrayList<Piece>();
//        rank.add(Piece.createBlackRook());
//        rank.add(Piece.createBlackKnight());
//        rank.add(Piece.createBlackBishop());
//        rank.add(Piece.createBlackQueen());
//        rank.add(Piece.createBlackKing());
//        rank.add(Piece.createBlackBishop());
//        rank.add(Piece.createBlackKnight());
//        rank.add(Piece.createBlackRook());
//        return rank;
//    }
//
//    public int getNumberOfPieces() {
//        return Piece.getPiecesInUse();
//    }
//
//    public int getNumberOfWhitePieces() {
//        return Piece.getNumberOfWhitePieces();
//    }
//
//    public int getNumberOfBlackPieces() {
//        return Piece.getNumberOfBlackPieces();
//    }
//
//    public String getRank(int rank) {
//        if (pieces.get(rank-1).size()==0) {
//            return "........";
//        }
//        StringBuilder builder = new StringBuilder();
//        for (int i=0; i<8; i++) {
//            builder.append(pieces.get(rank-1).get(i).getRepresentation());
//        }
//        return builder.toString();
//    }
//
//    public String print() {
//        StringBuilder builder = new StringBuilder();
//        for (int i=8; i>0; i--) {
//            builder.append(getRank(i));
//            builder.append(NEWLINE);
//        }
//        return builder.toString();
//    }
//
//
//    public int getNumberOfPiece(Piece.Color color, Piece.Type type) {
//        int result = 0;
//        for (ArrayList<Piece> innerPieces: pieces){
//            for (int i = 0; i < innerPieces.size(); i++){
//                Piece piece = innerPieces.get(i);
//                if (piece.getColor() == color && piece.getType() == type){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    public char getPiece(String coordinate) {
//        Point point = this.getPointToXY(coordinate);
//        return pieces.get(point.getY()).get(point.getX()).getRepresentation();
//    }
//
//    public void reset() {
//        Piece.resetCount();
//        pieces.clear();
//        for (int i=0; i < 8; i++){
//            ArrayList<Piece> rank = new ArrayList<Piece>();
//            rank.add(null);
//            rank.add(null);
//            rank.add(null);
//            rank.add(null);
//            rank.add(null);
//            rank.add(null);
//            rank.add(null);
//            rank.add(null);
//            pieces.add(rank);
//        }
//    }
//
//    public void addPiece(Piece piece, String coordinate) {
//        Point point = this.getPointToXY(coordinate);
//        ArrayList<Piece> rank = pieces.get(point.getY());
//        rank.add(point.getX(), piece);
//    }
//
//    private Point getPointToXY(String coordinate) {
//        int x = Character.getNumericValue(coordinate.substring(0,1).charAt(0)) - 9;
//        int y = Integer.parseInt(coordinate.substring(1, 2));
//        Point point = new Point(x - 1, y - 1);
//        return point;
//    }
}
