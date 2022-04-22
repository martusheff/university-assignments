package Enemy;

public class SkunkEnemyBuilder implements EnemyBuilder {
    private Enemy enemy;

    public SkunkEnemyBuilder() {
        this.enemy = new Enemy();
        enemy.name = "Skunk";
    }

    public void buildWeapon() {

        enemy.setAttack(new Attack("Spray", 15));
    }


    public void buildHealth() {
        enemy.setHP(10);
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
