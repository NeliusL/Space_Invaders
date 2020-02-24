package Graphics;

import Entities.Enemy;
import Entities.Player;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameScene extends JPanel implements ActionListener {

    public static int width;
    public static int height;

    private boolean running = false;
    private static List<Enemy> enemies;
    private Player player;

    private Thread thread;
    private BufferedImage bufferedImage;
    private Graphics2D  graphics2D;

    // Init the game Scene
    public GameScene(int w, int h){
        width = w;
        height = h;
        running = true;

        addKeyListener(new InputManager());

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();

        graphics2D = (Graphics2D) bufferedImage.getGraphics();

        InitEntities();
    }

    private void InitEntities() {
        player = new Player();
        enemies = new ArrayList<>();
        // Enemies generation
    }


    // Is called by repaint()
    // Use to draw different game states (Menu, In Game, Pause, End Screen...)
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // different drawing functions for different game states

        drawPlayer();
        drawEnemoes();
        drawProjectiles();

    }

    private void drawProjectiles() {
        //TODO
    }

    private void drawEnemoes() {
        //TODO
    }

    private void drawPlayer() {
        //TODO
    }

    // Update function called for any action that happen
    // Thank you very much. I don't have to make a loop
    @Override
    public void actionPerformed(ActionEvent e) {

        updatePlayer();
        updateEnemies();
        updateProjectiles();

        CollisionCheck();

        repaint();
    }

    private void updatePlayer() {
        //TODO
    }

    private void updateEnemies() {
        //TODO
    }

    private void updateProjectiles() {
        //TODO
    }

    private void CollisionCheck() {
        //TODO
    }


    // Key pressed Management redirected to player Input
    private class InputManager extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            Player.keyPressed(e);
        }
    }


}
