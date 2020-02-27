package Entities;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.LinkedList;

public class Entity {

    // Used to identify which side an entity belongs to
    public enum Team {
        PLAYER,
        ENEMIES
    };

    // In game related stats / date
    protected static LinkedList<Projectile> projectiles;

    protected static boolean CanMoveHorizontally;
    protected static boolean CanMoveVertically;
    protected static boolean CanTurn = false;
    protected static boolean CanShoot = false;
    protected static Team team;
    protected boolean live;
    protected int framesTillDeath;

    protected int hp;
    protected float attackSpeed;
    protected int onContactDMG;
    protected int shootDMG;

    // Position and orientation
    protected static int posX;
    protected static int posY;
    protected static int moveSpeed;

    protected static int deltaX;
    protected static int deltaY;

    protected static float angle;           // in radians
    protected static float turnSpeed;
    protected static float deltaTheta;

    // Graphics data
    protected ArrayList<Image> sprites;
    protected int nb_sprites;
    protected int currentsprite = 0;

    protected int width;
    protected int height;



    /** Sprites Loading, can load multiple sprites to allow animation later on
     * @param  path the path with sprite name + extension
     * @param  nb the number of sprites*/
    public void LoadSprites(String path, int nb){

        this.sprites = new ArrayList<>();
        // Useful values so that we only use one memory space for each
        // Or just facilitate the process
        Image tmp;
        ImageIcon ii;
        int n = path.length();
        String pathroot = path.substring(0, n-4);
        String end = path.substring(n-4);
        String tmppath;

        // Save this one since we know it
        this.nb_sprites = nb;

        for(int i = 0; i < nb; i++){
            tmppath = pathroot + i +end;
            ii = new ImageIcon(tmppath);
            tmp = ii.getImage();
            this.sprites.add(tmp);
        }

        this.width = this.getImage().getWidth(null);
        this.height = this.getImage().getHeight(null);
    }

    public static void Shoot(){ projectiles.add( new Projectile(angle, posX, posY, team)); }

    public void damage(int dmg){
        this.hp -= dmg;
        if (this.hp <= 0 )
            this.Kill();
    }

    public void Kill(){
    }

    // Getters
    // For game management
    public int getHP()    {return this.hp;}
    public int getPosX()   {return posX;}
    public int getPosY()   {return posY;}

    // For Update and Drawing
    public Image getImage()  {return this.sprites.get(0);}
    public LinkedList<Projectile> getProjectiles()    {return projectiles;}

    // For collision management, defines the hitbox
    public Rectangle getBounds() { return new Rectangle(posX, posY, width, height);}

}

