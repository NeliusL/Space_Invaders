package Graphics;

import Entities.Enemy;
import Entities.Player;
import Entities.Projectile;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


public class GameScene extends JPanel implements ActionListener {

    public static int width;
    public static int height;

    private boolean running = false;
    private static LinkedList<Enemy> enemies;
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

        InitEntities();
    }

    private void InitEntities() {
        player = new Player();
        enemies = new LinkedList<>();
        // Enemies generation
    }


    // Is called by repaint()
    // Use to draw different game states (Menu, In Game, Pause, End Screen...)
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // different drawing functions for different game states

        drawPlayer(g);
        drawEnemies(g);
        drawProjectiles(g);

    }

    /** Draw the projectiles
     * @param  graphics the graphic context*/
    private void drawProjectiles(Graphics graphics) {
        for (Projectile proj: player.getProjectiles()) {
            // if condition to add for explosion animation
            graphics.drawImage(proj.getImage(), proj.getPosX(), proj.getPosY(), this);
        }

        for(Enemy enemy : enemies) {
            for (Projectile proj : enemy.getProjectiles()) {
                // if condition to add for explosion animation
                graphics.drawImage(proj.getImage(), proj.getPosX(), proj.getPosY(), this);
            }
        }
    }

    /** Draw the enemies
     * @param  graphics the graphic context*/
    private void drawEnemies(Graphics graphics){
        for(Enemy enemy : enemies){
            // if condition to add for explosion animation
            graphics.drawImage(enemy.getImage(), enemy.getPosX(), enemy.getPosY(), this);
        }
    }

    /** Draw the Player
     * @param  graphics the graphic context*/
    private void drawPlayer(Graphics graphics) {
        // if condition to add for explosion animation
        graphics.drawImage(player.getImage(), player.getPosX(), player.getPosY(), this);
    }

    /** Update function called automatically whenever an action takes place
     * @param  e the event*/
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
        for (Enemy enemy : enemies){
            enemy.Update();
        }
    }

    private void updateProjectiles() {
        for (Projectile proj: player.getProjectiles()) {
            // if condition to add for explosion animation
            proj.Update();
            if (proj.getFrames_until_explosion() == -1)
                player.getProjectiles().remove(proj);
        }

        for(Enemy enemy : enemies) {
            for (Projectile proj : enemy.getProjectiles()) {
                // if condition to add for explosion animation
                proj.Update();
                if (proj.getFrames_until_explosion() == -1)
                    player.getProjectiles().remove(proj);
            }
        }
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
