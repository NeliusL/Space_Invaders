package Characters;

public class Player extends Character {
    public static final int PLAYER_HP = 3;
    public static final double PLAYER_MS = 0.3;

    public static Player Init(){
        Player player = new Player();
        player.HitPoints = PLAYER_HP;
        player.MoveSpeed = PLAYER_MS;
        // player.Sprite = img
        // TODO

        return player;
    }

    public static void Shoot(double targetx, double targety){
        // TODO
    }

}
