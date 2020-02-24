package Tools;

import Game.Game;
import Tools.Constants;

public class Settings {

    public void ChangeBinding(int control, int newBinding){
        Constants.keycodes[control] = newBinding;
    }

    public void WindowSize(int width, int height){

        // Change window size
    }

}
