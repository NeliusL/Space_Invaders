package Entities;

import Tools.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Projectile extends Entity {


    // Sprites
    protected ArrayList<Image> sprites;
    protected int nb_sprites;
    protected int currentsprite = 0;


    // Constructor
    /** Projectile Constructor
     * @param  pangle the angle at which it is shot
     * @param  x the x coordinate from where it is shot
     * @param  y the y coordinate from where it is shot*/
    public Projectile (float pangle, int x, int y, Team pteam){
        projectiles = null;
        CanMoveHorizontally = true;
        CanMoveVertically = true;
        CanTurn = false;
        // Game Data
        team = pteam;

        live = true;
        framesTillDeath = Constants.NB_PROJECTILE_EXPLOSION_SPRITE;

        hp = 1;
        attackSpeed = 0;
        onContactDMG = Constants.PROJECTILE_DAMAGE;
        shootDMG = 0;

        // Position and orientation
        posX = x;
        posY = y;
        moveSpeed = Constants.PROJECTILE_SPEED;

        angle = pangle;
        deltaX = (int) CalculateDeltaX();
        deltaY = (int) CalculateDeltaY();
        deltaTheta = 0;


        // Graphpics
        nb_sprites =  Constants.NB_PROJECTILE_SPRITE;
        LoadSprites(Constants.PROJECTILE_SPRITE,this.nb_sprites);

        width = getImage().getWidth(null);
        height = getImage().getHeight(null);

    }

    /** Sprites Loading, can load multiple sprites to allow animation later on
     * @param  path the path with sprite name + extension
     * @param  nb the number of sprites*/
    public void LoadSprites(String path, int nb){

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

    }

    public void Update(){
        posX += this.deltaX;
        posY += this.deltaY;

        if (!this.live)
            framesTillDeath -= 1;

        else if ((     posX >= Constants.GAME_MAX_WIDTH) ||
                ( posX <= Constants.GAME_MIN_WIDTH) ||
                ( posY >= Constants.GAME_MAX_HEIGHT) ||
                ( posY <= Constants.GAME_MIN_HEIGHT) ){
            this.Kill();
        }

    }

    public void Kill(){
        this.live = false;
        this.deltaX = 0;
        this.deltaY = 0;
        LoadSprites(Constants.PROJECTILE_EXPLOSION_SPRITE, Constants.NB_PROJECTILE_EXPLOSION_SPRITE);

    }


    public int getPosX()                {return posX;}
    public int getPosY()                {return posY;}
    public Image getImage()             {return this.sprites.get(this.currentsprite);}
    public int getFrames_until_explosion() {return framesTillDeath;}

    public int getDMG()                 {return this.onContactDMG;}
    protected void setDMG(int dmg)      {this.onContactDMG = dmg;}

    private float CalculateDeltaX()     {return (float) Math.cos(angle) / moveSpeed;}
    private float CalculateDeltaY()     {return (float) Math.sin(angle) / moveSpeed;}

    public Rectangle getBounds() { return new Rectangle(posX, posY, width, height);}


}
