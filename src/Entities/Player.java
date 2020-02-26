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
        this.posX =          Constants.PLAYER_STARTING_X;
        this.posY =          Constants.PLAYER_STARTING_Y;
        this.moveSpeed =     Constants.PLAYER_SPEED;
        this.attackSpeed =   Constants.PLAYER_ATTACK_SPEED;
        this.angle =         Constants.PLAYER_STARTING_ANGLE;
        this.projectiles =   new LinkedList<>();

        this.sprites = new ArrayList<>();
        LoadSprites(Constants.PLAYER_SPRITE, Constants.NB_PLAYER_SPRITE);
    }




    public static void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Cannot use switch because bindings are sadly not constant
        if     (key == keycodes[2] && CanMove)     posX = posX - moveSpeed;
        if     (key == keycodes[3] && CanMove)     posX = posX + moveSpeed;
        if     (key == keycodes[4] && CanTurn)     angle = Math.max(angle - turnSpeed, Constants.MAX_RIGHT_ROTATION);
        if     (key == keycodes[5] && CanTurn)     angle = Math.min(angle + turnSpeed, Constants.MAX_LEFT_ROTATION);

        else if     (key == keycodes[6] && CanShoot)    Shoot();

        if     (key == keycodes[0] && CanMove)     posY = posY - moveSpeed;
        if     (key == keycodes[1] && CanMove)     posY = posY + moveSpeed;
        if     (key == KeyEvent.VK_Y)              System.out.println("" + posX + ", "+ posY);

    }


}
