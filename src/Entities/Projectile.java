package Entities;

import Tools.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.transform.Source;

public class Projectile {
    private static int shooter;    // 1 = Player, 2 = Enemy

    private float posX;
    private float posY;

    private float speed;
    private float angle;
    private float deltaX;
    private float deltaY;


    public Projectile (float angle, float x, float y){
        this.speed = Constants.PROJECTILE_SPEED;
        this.posX = x;
        this.posY = y;
        this.angle = angle;
        this.deltaX = CalculateDeltaX();
        this.deltaY = CalculateDeltaY();
    }


    public static void Draw(){
        // TODO
    }

    public void Update(){
        this.posX += this.deltaX;
        this.posY += this.deltaY;

    }

    public static void Kill(){
        // TODO
    }


    private float CalculateDeltaX()      {return (float) Math.cos(this.angle) / this.speed;}
    private float CalculateDeltaY()     {return (float) Math.sin(this.angle) / this.speed;}

}
