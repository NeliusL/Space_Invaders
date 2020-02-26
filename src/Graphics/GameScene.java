package Graphics;

import Entities.Enemy;
import Entities.Player;
import Entities.Projectile;
import Tools.Constants;


import javax.imageio.ImageIO;
import javax.swing.*;
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

    private Image back;

    private Timer timer;
    int DELAY = 15;

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

        back = new ImageIcon("resources/space.jpg").getImage();

        addKeyListener(new InputManager());

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();

        InitEntities();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void InitEntities() {
        player = new Player();
        //enemies = new LinkedList<>();
        // Enemies generation
    }


    // Is called by repaint()
    // Use to draw different game states (Menu, In Game, Pause, End Screen...)
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // different drawing functions for different game states

        drawPlayer(g);
        //drawEnemies(g);
        //drawProjectile

        Toolkit.getDefaultToolkit().sync();


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
        graphics.drawImage(back, 0, 0, this);
        graphics.drawImage(player.getImage(), player.getPosX(), player.getPosY(), this);
    }

    /** Update function called automatically whenever an action takes place
     * @param  e the event*/
    @Override
    public void actionPerformed(ActionEvent e) {

        // Player position already updated automatically
        //updateEnemies();
        //updateProjectiles();

        // collision checked during update to avoid calling multiple loops to go through each lists every time
        repaint();
    }


    // Apply when enemies reach end of line
    private void Reached_End() {
        for (Enemy enemy : enemies) {
            enemy.InvertDirection();
            enemy.MoveDown();
        }
    }

    private void updateEnemies() {
        Enemy left = getMostLeftEnemy();
        left.setMostLeft(true);

        Enemy right = getMostRightEnemy();
        right.setMostRightht(true);

        if ((left.getPosX() <= Constants.GAME_MIN_WIDTH + 5) ||
                (right.getPosX() >= Constants.GAME_MAX_WIDTH - 5)) {
            Reached_End();
        }

        // Actually move the enemies
        for (Enemy e : enemies){
            e.MoveSideways();
            PlayerCollision(e);     // Check Collision
        }
    }

    private void updateProjectiles() {
        for (Projectile proj: player.getProjectiles()) {
            // if condition to add for explosion animation
            proj.Update();
            if (proj.getFrames_until_explosion() == -1){
                player.getProjectiles().remove(proj);
                ProjectileCollisionCheck(proj);
            }
        }

        for(Enemy enemy : enemies) {
            for (Projectile proj : enemy.getProjectiles()) {
                // if condition to add for explosion animation
                proj.Update();
                if (proj.getFrames_until_explosion() == -1){
                    player.getProjectiles().remove(proj);
                    ProjectileCollisionCheck(proj);
                }
            }
        }
    }

    /**
     * Chack Collision between enemy projetile and player
     * @param projectile the projectile we re checking
     */
    private void ProjectileCollisionCheck(Projectile projectile) {
        Rectangle playerHitbox = player.getBounds();
        if (playerHitbox.intersects(projectile.getBounds())){
            projectile.Kill();
            player.damage(projectile.getDMG());
        }
    }

    /**
     * collision check between player and enemies
     * @param e the enemy with which we're checking
     */
    private void PlayerCollision(Enemy e){
        Rectangle playerHitbox = player.getBounds();
        if (playerHitbox.intersects(e.getBounds()))
            player.damage(Constants.CONTACT_DAMAGE);
    }

    /**
     * Checking if the player projectiles hit the enemies
     * Call this function in the player update loop to get the projectiles tht he's shooting
     * @param p the projectile we're checking
     */
    private void AlienCollision(Projectile p){
        Rectangle projectileHitBox = p.getBounds();
        for (Enemy e : enemies){
            if (projectileHitBox.intersects(e.getBounds())){
                p.Kill();
                e.damage(p.getDMG());
            }
        }
    }

    private Enemy getMostLeftEnemy(){
        Enemy enemy = null;
        int minX = Constants.GAME_MAX_WIDTH;
        int tmp;
        for (Enemy e : enemies){
            tmp = e.getPosX();
            if (tmp < minX){
                minX = tmp;
                enemy = e;
            }
        }
            return enemy;
    }

    private Enemy getMostRightEnemy() {
        Enemy enemy = null;
        int maxX = Constants.GAME_MIN_WIDTH;
        int tmp;
        for (Enemy e : enemies) {
            tmp = e.getPosX();
            if (tmp > maxX) {
                maxX = tmp;
                enemy = e;
            }
        }
        return enemy;
    }

    private int getEnemyLeftPos(){ return getMostLeftEnemy().getPosX();}
    private int getEnemyRightPos(){ return getMostRightEnemy().getPosX();}


    // Key pressed Management redirected to player Input
    private class InputManager extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }


}
