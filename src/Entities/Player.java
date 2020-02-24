package Entities;

import Tools.Constants;

import static Tools.Constants.keycodes;

public class Player extends Character{

    public Player(){
        posX = 0f;
        posY = -0.2f;
    }

    public static void Actions(int key){
        // Cannot use switch because bindings are not constant
        if          (key == keycodes[2] && CanMove)     posX -= moveSpeed;
        else if     (key == keycodes[3] && CanMove)     posX += moveSpeed;
        else if     (key == keycodes[4] && CanTurn)     angle -= turnSpeed;
        else if     (key == keycodes[5] && CanTurn)     angle += turnSpeed;
        else if     (key == keycodes[6] && CanShoot)    Shoot();

    }

    public static void Shoot(){

    }


}
