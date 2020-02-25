package Entities;

import Tools.Constants;

import java.util.ArrayList;
import java.util.LinkedList;

public class Enemy extends Character {
    int packposX;
    int packposY;
    int gravity;

    boolean mostLeft;
    boolean mostRight;

    public Enemy(int ppx, int ppy, boolean mostL, boolean mostR){
        packposX = ppx;
        packposY = ppy;
        GetRealCoord();

        // For Enemy movement
        mostLeft = mostL;
        mostRight = mostR;

        moveSpeed = Constants.ENEMY_SPEED;
        attackSpeed =   Constants.ENEMY_ATTACK_SPEED;
        angle =         Constants.PLAYER_STARTING_ANGLE;
        projectiles =   new LinkedList<>();
        gravity =       Constants.GRAVITY;

        LoadSprites(Constants.ENEMY_SPRITE, Constants.NB_ENEMY_SPRITE);

    }

    public void MoveLeft()  { posX -= moveSpeed;}
    public void MoveRight() { posX += moveSpeed;}
    public void MovveDown() { posY -= gravity;}


    // real int posx and posy based on position in the pack
    public void GetRealCoord(){
        // TODO
        // posx = offset * packposX
        // posy = offset * packposY
    }

    public void getMostLeft(){}
    public void getMostRight(){ }

}
