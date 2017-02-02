package chess;

import pieces.Pawn;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-02-02.
 */
public class Board {

    private ArrayList<Pawn> pawns = new ArrayList<Pawn>();

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
