package Entities;

import Tools.Constants;
import org.w3c.dom.html.HTMLParagraphElement;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Tools.Constants.keycodes;

public class Player extends Character{


    public Player(){
        posX =          Constants.PLAYER_STARTING_X;
        posY =          Constants.PLAYER_STARTING_Y;
        moveSpeed =     Constants.PLAYER_SPEED;
        attackSpeed =   Constants.PLAYER_ATTACK_SPEED;
        angle =         Constants.PLAYER_STARTING_ANGLE;
        projectiles =   new LinkedList<>();

        LoadSprites(Constants.PLAYER_SPRITE, Constants.NB_PLAYER_SPRITE);
    }


    public static void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Cannot use switch because bindings are sadly not constant
        if          (key == keycodes[2] && CanMove)     posX = Math.max(posX - moveSpeed, Constants.GAME_MIN_WIDTH);
        else if     (key == keycodes[3] && CanMove)     posX = Math.min(posX + moveSpeed, Constants.GAME_MAX_WIDTH);
        else if     (key == keycodes[4] && CanTurn)     angle = Math.max(angle - turnSpeed, Constants.MAX_RIGHT_ROTATION);
        else if     (key == keycodes[5] && CanTurn)     angle = Math.min(angle + turnSpeed, Constants.MAX_LEFT_ROTATION);

        else if     (key == keycodes[6] && CanShoot)    Shoot();

    }


}
