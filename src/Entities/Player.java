package Entities;

import Tools.Constants;
import com.sun.jdi.connect.spi.TransportService;
import org.w3c.dom.html.HTMLParagraphElement;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Tools.Constants.keycodes;

public class Player extends Character{

    private static boolean leftPressed;
    private static boolean rightPressed;
    private static int deltaX;
    private static int deltaY;
    private static float deltaangle;
    private static boolean CanUpNDown;

    public Player(){
        this.posX =          Constants.PLAYER_STARTING_X;
        this.posY =          Constants.PLAYER_STARTING_Y;
        this.moveSpeed =     Constants.PLAYER_SPEED;
        this.attackSpeed =   Constants.PLAYER_ATTACK_SPEED;
        this.angle =         Constants.PLAYER_STARTING_ANGLE;
        this.projectiles =   new LinkedList<>();

        this.sprites = new ArrayList<>();
        LoadSprites(Constants.PLAYER_SPRITE, Constants.NB_PLAYER_SPRITE);

        CanUpNDown = true;
    }

    public void Update() {
        posX = Math.max(Math.min(posX + deltaX, Constants.GAME_MAX_WIDTH), Constants.GAME_MIN_WIDTH) ;
        posY = Math.min(Math.max(posY + deltaY, Constants.GAME_MAX_HEIGHT), Constants.GAME_MIN_HEIGHT);
        angle = Math.max(Math.min(angle + deltaangle, Constants.MAX_LEFT_ROTATION), Constants.MAX_RIGHT_ROTATION);
    }



    public static void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Cannot use switch because bindings are sadly not constant
        if     (key == keycodes[2] && CanMove)     {deltaX = -moveSpeed;    leftPressed = true;}
        if     (key == keycodes[3] && CanMove)     {deltaX =  moveSpeed;     rightPressed = true;}
        if     (key == keycodes[4] && CanTurn)     deltaangle = -turnSpeed;
        if     (key == keycodes[5] && CanTurn)     deltaangle = turnSpeed;

        else if     (key == keycodes[6] && CanShoot)    Shoot();

        if     (key == keycodes[0] && CanUpNDown)     deltaY = -moveSpeed;
        if     (key == keycodes[1] && CanUpNDown)     deltaY =  moveSpeed;
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
        if     (key == keycodes[4] && CanTurn)     deltaangle = 0;
        if     (key == keycodes[5] && CanTurn)     deltaangle = 0;

        if     (key == keycodes[0] && CanUpNDown)     deltaY =  0;
        if     (key == keycodes[1] && CanUpNDown)     deltaY =  0;
        //if     (key == KeyEvent.VK_Y)              System.out.println("" + posX + ", "+ posY);
    }


}
