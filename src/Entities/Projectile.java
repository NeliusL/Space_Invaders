package Entities;

import Tools.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.util.ArrayList;

public class Projectile {
    private static int shooter;    // 1 = Player, 2 = Enemy

    // Game Data
    private int posX;
    private int posY;
    private float deltaX;
    private float deltaY;

    private int damage;

    private float speed;
    private float angle;

    private int width;
    private int height;
    private boolean live;
    private int frames_until_explosion;


    // Sprites
    protected ArrayList<Image> sprites;
    protected int nb_sprites;
    protected int currentsprite = 0;


    // Constructor
    /** Projectile Constructor
     * @param  angle the angle at which it is shot
     * @param  x the x coordinate from where it is shot
     * @param   y the y coordinate from where it is shot*/
    public Projectile (float angle, int x, int y){
        // Game Data
        this.speed = Constants.PROJECTILE_SPEED;
        this.posX = x;
        this.posY = y;
        this.angle = angle;
        this.deltaX = CalculateDeltaX();
        this.deltaY = CalculateDeltaY();

        this.damage = Constants.PROJECTILE_DAMAGE;

        this.live = true;
        this.frames_until_explosion = Constants.NB_PROJECTILE_EXPLOSION_SPRITE;

        // Graphpics
        this.currentsprite =  Constants.NB_PROJECTILE_SPRITE;
        LoadSprites(Constants.PROJECTILE_SPRITE,this.nb_sprites);
        this.width = getImage().getWidth(null);
        this.height = getImage().getHeight(null);

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
        this.posX += this.deltaX;
        this.posY += this.deltaY;

        if (!this.live)
            frames_until_explosion -= 1;

        else if ((     this.posX > Constants.GAME_MAX_WIDTH) ||
                ( this.posX < Constants.GAME_MIN_WIDTH) ||
                ( this.posY > Constants.GAME_MAX_HEIGHT) ||
                ( this.posY < Constants.GAME_MIN_HEIGHT) ){
            this.Kill();
        }

    }

    public void Kill(){
        this.live = false;
        this.deltaX = 0;
        this.deltaY = 0;
        LoadSprites(Constants.PROJECTILE_EXPLOSION_SPRITE, Constants.NB_PROJECTILE_EXPLOSION_SPRITE);

    }


    public int getPosX()                {return this.posX;}
    public int getPosY()                {return this.posY;}
    public Image getImage()             {return this.sprites.get(this.currentsprite);}
    public int getFrames_until_explosion() {return frames_until_explosion;}

    public int getDMG()                 {return this.damage;}
    protected void setDMG(int dmg)      {this.damage = dmg;}

    private float CalculateDeltaX()     {return (float) Math.cos(this.angle) / this.speed;}
    private float CalculateDeltaY()     {return (float) Math.sin(this.angle) / this.speed;}

    public Rectangle getBounds() { return new Rectangle(posX, posY, width, height);}


}
