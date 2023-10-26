import java.awt.*;

public class Config {
    public static final int SIZE = 50;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int SLEEP = 50;

    public static Color getColor (CellStatus status){
        switch (status){
            case None: return Color.BLACK;
            case Live: return Color.WHITE;
            case Born: return Color.GRAY  ;
            case Died: return Color.RED;
            default: return null;
        }
    }

}
