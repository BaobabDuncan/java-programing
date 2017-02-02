package pieces;

/**
 * Created by Administrator on 2017-02-01.
 */
public class Pawn {
    public static final String white = "white";
    public static final String black = "black";
    private String color;
    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
