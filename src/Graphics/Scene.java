package Graphics;

import javax.swing.JPanel;
import java.awt.*;

public class Scene extends JPanel {

    public static int width;
    public static int height;

    public Scene(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }
}
