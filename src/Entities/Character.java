package Entities;

public class Character {
    protected static int hp;
    protected static float moveSpeed;
    protected static float turnSpeed = 0;

    protected static boolean CanMove = false;
    protected static boolean CanTurn = false;
    protected static boolean CanShoot = false;

    protected static float posX;
    protected static float posY;
    protected static float angle;



    // Getters
    public static double getHP()    {return hp;}
    public static float getPosX()   {return posX;}
    public static float getPosY()   {return posY;}

}
