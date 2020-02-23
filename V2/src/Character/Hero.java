package Character;

import edu.princeton.cs.introcs.StdDraw;

public class Hero {
    public static void DisplayCharacter() {
        double pos_x = 0.0;
        double pos_y = 0.0;

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(pos_x, pos_y, .05);
    }
}
