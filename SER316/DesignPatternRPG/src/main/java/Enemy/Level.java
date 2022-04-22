package Enemy;

import Play.Mediator;

public class Level {

    private EnemyBuilder enemyBuilder;
    protected Mediator mediator;
    public String backyardFamily;

    public Level(EnemyBuilder enemyBuilder, Mediator mediator, String backyardFamily) {
        this.enemyBuilder = enemyBuilder;
        this.mediator = mediator;
        this.backyardFamily = backyardFamily;
    }

    public void constructEnemy() {
        this.enemyBuilder.buildHealth();
        this.enemyBuilder.buildWeapon();
    }

    public Enemy getEnemy() {
        return enemyBuilder.getEnemy();
    }


}
