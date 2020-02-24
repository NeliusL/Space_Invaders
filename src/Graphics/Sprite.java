package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Sprite {
    protected float posX;
    protected float posY;
    protected int width;
    protected int height;
    protected Image image;

    public Sprite(float x, float y, String file){
        this.posX = x;
        this.posY = y;
        this.image = new ImageIcon(file).getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public Image getImage() {return image;}
}
