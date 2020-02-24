package Tools;

import static java.awt.event.KeyEvent.*;


public class Constants {


    // Window Settings
    public static int WINDOW_HEIGHT =   720;
    public static int WINDOW_WIDTH =    480;
    public static String WINDOW_NAME =  "Space Invaders";

    // Game Initilisation constants
    public static final float PI =                      (float) Math.PI;
    public static final float PLAYER_STARTING_X =       0f;
    public static final float PLAYER_STARTING_Y =       -0.3f;
    public static final float PLAYER_STARTING_ANGLE =   PI / 2;     // In radians

    // Game Settings
    public static final float GAME_MIN_WIDTH =      -1;
    public static final float GAME_MAX_WIDTH =       1;
    public static final float GAME_MIN_HEIGHT =     -1;
    public static final float GAME_MAX_HEIGHT =      1;
    public static final float MAX_RIGHT_ROTATION =   PI/4;
    public static final float MAX_LEFT_ROTATION =    PI*3/4;

    // Game Balancing
    public static final float PLAYER_ATTACK_SPEED =     2;          // Attack per seconds
    public static final float PROJECTILE_SPEED = 0.3f ;


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
