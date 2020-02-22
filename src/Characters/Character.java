package Characters;


public class Character {
    // Game management
    public static int HitPoints;
    public static double MoveSpeed;

    public static boolean CanMove = true;      // Sideways movement
    public static boolean CanRotate = true;    // Rotation
    public static float posX = 0;
    public static float posY = 0;
    public static float width = 0.1f;
    public static float height = 0.1f;

    // public static ##insert image type## Sprite;

    public static Character Init(int HP, double MS, String imgpath){
        Character character = new Character();
        character.HitPoints = HP;
        character.MoveSpeed = MS;

        // TODO
        // Get image and save it as character.Sprite = img

        return character;
    }

    /* Mayber better to set Movement Quaternion to null (0,0,0,0) (with JOML (org.joml.Quaterniond)
    Or just a 3 dimensional vector (with Math library + 1 variable for the rotation)
    Quaternion = 4 Dimensional vector (x, y , z and rotation)

    // Lock a character's Position (Most likely the player for level 1)
    public void LockCharacterPos(Character character)    { if (this.CanMove) this.CanMove = false; }

    // Unlock a character's Position (Most likely the player after completing level 1)
    public void UnlockCharacterPos(Character character)  {if (!this.CanMove) this.CanMove = true; }

    // Lock character's Rotation ( For the enemies, to make sure nothing goes wrong)
    public void LockRotation (Character character)       {if (this.CanRotate) this.CanRotate = false; }

    // Lock character's Rotation ( For the enemies, to make sure nothing goes wrong)
    public void UnlockRotation (Character character)       {if (!this.CanRotate) this.CanRotate = true; }
    */



    // Update position of the character based on a quaternion (4D vector)
    public static void Update_Pos(){
        // TODO
    }

    public static void Update_Img(){
        //TODO
    }

    public static void Display(){
        //TODO
    }

    public static void Kill(){
        //TODO
    }

}
