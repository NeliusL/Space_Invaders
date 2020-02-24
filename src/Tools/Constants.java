package Tools;

import static java.awt.event.KeyEvent.*;


public class Constants {

    // Window Settings
    public static int WINDOW_HEIGHT =   720;
    public static int WINDOW_WIDTH =    480;
    public static String WINDOW_NAME =  "Space Invaders";

    // Game Initilisation constants

    // Bindings : their number is their index in the keycode list
    public static int[] keycodes = {
            VK_W,       // 0 = UP
            VK_S,       // 1 = DOWN
            VK_A,       // 2 = LEFT
            VK_D,       // 3 = RIGHT
            VK_E,       // 4 = TURN RIGHT
            VK_Q,       // 5 =TURN LEFT
            VK_SPACE,   // 6 =SHOOT
    };

}
