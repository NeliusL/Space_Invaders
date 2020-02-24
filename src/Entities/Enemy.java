package Entities;

import Tools.Constants;

import java.util.ArrayList;

public class Enemy extends Character {
    int packposX;
    int packposY;
    int gravity;

    public Enemy(int ppx, int ppy){
        packposX = ppx;
        packposY = ppy;
        GetRealCoord();

        moveSpeed = Constants.ENEMY_SPEED;
        attackSpeed =   Constants.ENEMY_ATTACK_SPEED;
        angle =         Constants.PLAYER_STARTING_ANGLE;
        projectiles =   new ArrayList<>();
        gravity =       Constants.GRAVITY;

        LoadSprites(Constants.ENEMY_SPRITE, Constants.NB_ENEMY_SPRITE);

    }

    public void MoveLeft()  { posX -= moveSpeed;}
    public void MoveRight() { posX += moveSpeed;}
    public void MovveDown() { posY -= gravity;}

    public void GetRealCoord(){
        // TODO
        // posx = offset * packposX
        // posy = offset * packposY
    }
}
