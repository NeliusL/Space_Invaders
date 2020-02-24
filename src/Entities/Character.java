package Entities;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Character{
    protected int hp;
    protected float moveSpeed;
    protected float turnSpeed = 0;

    protected boolean CanMove = false;
    protected boolean CanTurn = false;
    protected boolean CanShoot = false;

    protected ArrayList<Image> sprites;
    protected int nb_sprites;
    protected int currentsprite;
    protected float posX;
    protected float posY;
    protected float angle;           // in radians
    protected float attackSpeed;     // Attack per second



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

    // Getters
    public double getHP()    {return this.hp;}
    public float getPosX()   {return this.posX;}
    public float getPosY()   {return this.posY;}

}
