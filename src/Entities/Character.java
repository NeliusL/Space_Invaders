package Entities;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Character{

    protected static List<Projectile> projectiles;

    // game infos / stats
    protected static boolean CanMove = false;
    protected static boolean CanTurn = false;
    protected static boolean CanShoot = false;
    protected int hp;
    protected float attackSpeed;     // Attack per second


    // Sprites
    protected ArrayList<Image> sprites;
    protected int nb_sprites;
    protected int currentsprite = 0;

    // Position
    protected static int posX;
    protected static int posY;
    protected static int moveSpeed;

    protected int width;
    protected int height;

    protected static float angle;           // in radians
    protected static float turnSpeed = 0;


    /** Sprites Loading, can load multiple sprites to allow animation later on
     * @param  path the path with sprite name + extension
     * @param  nb the number of sprites*/
    public void LoadSprites(String path, int nb){

        // Useful values so that we only use one memory space for each
        // Or just facilitate the process
        Image tmp;
        int n = path.length();
        String pathroot = path.substring(0, n-4);
        String end = path.substring(n-4);
        String tmppath;

        // Save this one since we know it
        this.nb_sprites = nb;

        for(int i = 0; i < nb; i++){
            tmppath = pathroot + i +end;
            tmp = new ImageIcon(tmppath).getImage();
            this.sprites.add(tmp);
        }

    }

    public static void Shoot(){ projectiles.add( new Projectile(angle, posX, posY)); }

    // Getters
    // For game management
    public double getHP()    {return this.hp;}
    public float getPosX()   {return this.posX;}
    public float getPosY()   {return this.posY;}

    // For Update and Drawing
    public Image getImage()  {return this.sprites.get(this.currentsprite);}
    public List<Projectile> getProjectiles()    {return this.projectiles;}

    // For collision management
    public Rectangle getBounds() { return new Rectangle(posX, posY, width, height);}

}
