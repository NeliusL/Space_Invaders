package Tools;

import Tools.Constants;

public class Settings {

    public static void ChangeBinding(int control, int newBinding){
        Constants.keycodes[control] = newBinding;
    }

    public static void WindowSize(int width, int height){
        Constants.WINDOW_WIDTH = width;
        Constants.WINDOW_HEIGHT = height;
        // Change window size
    }

}
