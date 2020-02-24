package Graphics;


import Game.Game;
import Graphics.Scene;
import Tools.Constants;

import javax.swing.JFrame;

public class Window extends JFrame{

    public static int height = Constants.WINDOW_HEIGHT;
    public static int width = Constants.WINDOW_WIDTH;

    public Window(String GameTitle){
        setTitle(GameTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Scene(width, height));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
