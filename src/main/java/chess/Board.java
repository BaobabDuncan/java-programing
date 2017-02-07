package chess;

import pieces.Pawn;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-02.
 */
public class Board {

    private ArrayList<Pawn> pawns = new ArrayList<Pawn>();

    public void Board(){
//        ArrayList<Pawn> WhitePawns = new ArrayList<Pawn>();
//        ArrayList<Pawn> BlackPawns = new ArrayList<Pawn>();
//
//        for (int i = 0 ; i < 8; i++){
//            Pawn pawn = new Pawn(Pawn.white);
//            WhitePawns.add(pawn);
//        }
//        for (int i = 0 ; i < 8; i++){
//            Pawn pawn = new Pawn(Pawn.black);
//            BlackPawns.add(pawn);
//        }

    }

    public int getNumberOfPawns() {
        return pawns.size();
    }

    public void enroll(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn get(int index) {
        return pawns.get(index);
    }
}
