package Characters;

public class Enemy extends Character {
    public static final int ENEMY_HP = 1;
    public static final double ENEMY_MS = 0.2;

    public static Enemy Init(){

        Enemy enemy = new Enemy();
        Enemy.HitPoints = ENEMY_HP;
        Enemy.MoveSpeed = ENEMY_MS;

        return enemy;
    }


}
