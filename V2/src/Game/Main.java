package Game;

import edu.princeton.cs.introcs.Draw;
import edu.princeton.cs.introcs.DrawListener;


import java.awt.*;

public class Main implements DrawListener {
    //Player starting position
    double pos_x = 0.0;
    double  pos_y = 0.0;
    private Draw draw = new Draw();

    public  Main() {
        draw.enableDoubleBuffering();
        draw.addListener(this);
        draw.setXscale(-1.0, 1.0);
        draw.setYscale(-1.0, 1.0);
        draw.clear(Color.GRAY);
        draw.setPenColor(Color.red);
        draw.filledCircle(pos_x, pos_y, 0.02);
        draw.show();
        draw.pause(10);
    }
    @Override
    public void mousePressed(double x, double y) {

    }

    @Override
    public void mouseDragged(double x, double y) {

    }

    @Override
    public void mouseReleased(double x, double y) {

    }

    @Override
    public void mouseClicked(double x, double y) {

    }

    @Override
    public void keyTyped(char c) {
        if(c == 'w') {
            pos_y += 0.02; //up
            System.out.println("w pressed");
        }
        else if(c == 's') pos_y -= 0.02; //down
        else if(c== 'a') pos_x -= 0.02; //left
        else if(c == 'd') pos_x += 0.02; //right

        draw.clear(Color.gray);
        draw.setPenColor(Color.red);
        draw.filledCircle(pos_x, pos_y, 0.02);
        draw.show();
        draw.pause(10);
    }

    @Override
    public void keyPressed(int keycode) {

    }

    @Override
    public void keyReleased(int keycode) {

    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
