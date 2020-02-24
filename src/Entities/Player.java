package Entities;

import Tools.Constants;
import org.w3c.dom.html.HTMLParagraphElement;

import static Tools.Constants.keycodes;

public class Player extends Character{

    static Projectile[] projectiles = new Projectile[] {new Projectile((float)Math.PI/2f, 0, -0.5f)};

    public Player(){
        posX =          Constants.PLAYER_STARTING_X;
        posY =          Constants.PLAYER_STARTING_Y;
        attackSpeed =   Constants.PLAYER_ATTACK_SPEED;
        angle =         Constants.PLAYER_STARTING_ANGLE;
    }


    private static float tmp;      // used for calculation purposes

    public void Actions(int key){
        // Cannot use switch because bindings are sadly not constant
        if          (key == keycodes[2] && CanMove)     posX = Math.max(posX - moveSpeed, Constants.GAME_MIN_WIDTH);
        else if     (key == keycodes[3] && CanMove)     posX = Math.min(posX + moveSpeed, Constants.GAME_MAX_WIDTH);
        else if     (key == keycodes[4] && CanTurn)     angle = Math.max(angle - turnSpeed, Constants.MAX_RIGHT_ROTATION);
        else if     (key == keycodes[5] && CanTurn)     angle = Math.min(angle + turnSpeed, Constants.MAX_LEFT_ROTATION);

        else if     (key == keycodes[6] && CanShoot)    Shoot();

    }

    public static void Shoot(){

    }

    public static void Update(){
    }


}
