package Enemy;

public class MouseEnemyBuilder implements EnemyBuilder {

    private Enemy enemy;

    public MouseEnemyBuilder() {
        this.enemy = new Enemy();
        enemy.name = "Mouse";
    }

    public void buildWeapon() {
        enemy.setAttack(new Attack("Nibble", 5));
    }


    public void buildHealth() {
        enemy.setHP(5);
    }

    public Enemy getEnemy() {
        return enemy;
    }


}
