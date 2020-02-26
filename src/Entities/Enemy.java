package Entities;

import Tools.Constants;

import java.util.ArrayList;
import java.util.LinkedList;

public class Enemy extends Character {
    protected int packposX;
    protected int packposY;
    protected int gravity;

    protected boolean mostLeft;
    protected boolean mostRight;

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

    // Call thiese functions in the update things.
    // We just change the sign of moveSpeed to change the direction and make it go either left or right
    public void MoveSideways()  { posX += moveSpeed;}
    public void MoveDown() { posY -= gravity;}

    // Used to modify movements of the enemy
    public void InvertDirection()    {moveSpeed = -moveSpeed;}


    // real int posx and posy based on position in the pack
    public void GetRealCoord(){
        // TODO
        // posx = offset * packposX
        // posy = offset * packposY
    }

    public void getMostLeft(){}
    public void getMostRight(){ }
    public void setMostLeft(boolean val) {this.mostLeft = val;}
    public void setMostRightht(boolean val) {this.mostRight = val;}


}
