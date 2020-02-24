package Graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Scene extends JPanel implements Runnable {
    int x = 0;
    public static int width;
    public static int height;

    private boolean running = false;

    private Thread thread;
    private BufferedImage bufferedImage;
    private Graphics2D  graphics2D;

    public Scene(int width, int height){
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();

        if (thread == null){
            thread = new Thread(this, "Game Thread");
            thread.start();
        }

    }

    public void init(){
        running = true;

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) bufferedImage.getGraphics();
        
    }

    public void run(){
        init();

        
        while (running){
            update();
            render();
            draw();
        }
    }

    private void draw() {
    }

    private void render() {
    }

    public void update(){
        x++;
        System.out.println(x);
        
    }
    

}
