package Entities;

import Tools.Constants;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;


import static Entities.Character.CanMove;
import static Tools.Constants.keycodes;

public class Player extends Entity{

    private static boolean leftPressed;
    private static boolean rightPressed;

    public Player(){
        projectiles = new LinkedList<>();

        CanMoveHorizontally = true;
        CanMoveVertically = true;
        CanShoot = true;

        team = Team.PLAYER;
        live = true;
        framesTillDeath = Constants.NB_PLAYER_DEATH_SPRITE;

        hp = Constants.PLAYER_HP;
        attackSpeed =   Constants.PLAYER_ATTACK_SPEED;
        onContactDMG = 0;
        shootDMG = Constants.PLAYER_DMG

        posX =          Constants.PLAYER_STARTING_X;
        posY =          Constants.PLAYER_STARTING_Y;
        moveSpeed =     Constants.PLAYER_SPEED;
        angle =         Constants.PLAYER_STARTING_ANGLE;
        projectiles =   new LinkedList<>();

        sprites = new ArrayList<>();
        LoadSprites(Constants.PLAYER_SPRITE, Constants.NB_PLAYER_SPRITE);
    }

    public void Update() {
        posX = Math.max(Math.min(posX + deltaX, Constants.GAME_MAX_WIDTH), Constants.GAME_MIN_WIDTH) ;
        posY = Math.min(Math.max(posY + deltaY, Constants.GAME_MAX_HEIGHT), Constants.GAME_MIN_HEIGHT);
        angle = Math.max(Math.min(angle + deltaTheta, Constants.MAX_LEFT_ROTATION), Constants.MAX_RIGHT_ROTATION);
    }



    public static void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Cannot use switch because bindings are sadly not constant
        if     (key == keycodes[2] && CanMove)     {deltaX = -moveSpeed;    leftPressed = true;}
        if     (key == keycodes[3] && CanMove)     {deltaX =  moveSpeed;     rightPressed = true;}
        if     (key == keycodes[4] && CanTurn)     deltaTheta = -turnSpeed;
        if     (key == keycodes[5] && CanTurn)     deltaTheta = turnSpeed;

        else if     (key == keycodes[6] && CanShoot)    Shoot();

        if     (key == keycodes[0] && CanMoveVertically)     deltaY = -moveSpeed;
        if     (key == keycodes[1] && CanMoveVertically)     deltaY =  moveSpeed;
        //if     (key == KeyEvent.VK_Y)              System.out.println("" + posX + ", "+ posY);
    }

    public static void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // Cannot use switch because bindings are sadly not constant
        if     (key == keycodes[2]) {
            leftPressed = false;
            if (!rightPressed)
                deltaX = 0;
        }
        if     (key == keycodes[3] && CanMove){
            rightPressed = false;
            if (!leftPressed)
                deltaX = 0;
        }
        if     (key == keycodes[4] && CanTurn)     deltaTheta = 0;
        if     (key == keycodes[5] && CanTurn)     deltaTheta = 0;

        if     (key == keycodes[0] && CanMoveVertically)     deltaY =  0;
        if     (key == keycodes[1] && CanMoveVertically)     deltaY =  0;
        //if     (key == KeyEvent.VK_Y)              System.out.println("" + posX + ", "+ posY);
    }


}
