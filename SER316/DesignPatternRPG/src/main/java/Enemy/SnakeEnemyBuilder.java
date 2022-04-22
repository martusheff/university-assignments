package Enemy;

public class SnakeEnemyBuilder implements EnemyBuilder {

    private Enemy enemy;

    public SnakeEnemyBuilder() {
        this.enemy = new Enemy();
        enemy.name = "Snake";
    }

    public void buildWeapon() {
        enemy.setAttack(new Attack("Poison", 30));
    }


    public void buildHealth() {
        enemy.setHP(15);
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
