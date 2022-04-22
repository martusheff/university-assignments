package Play;

import Enemy.*;

import Hero.Cat;
import Support.Support;

import java.util.ArrayList;

public class GameMediator implements Mediator {

    public final int MAX_ROUNDS = 30;
    public final int TICK_RATE = 750;
    private ArrayList<Enemy> enemies;
    Support helper = new Support();

    enum LevelType {
        EASY,
        MEDIUM,
        HARD
    }

    public GameMediator() {
        enemies = new ArrayList<Enemy>();
    }

    @Override
    public Cat createCatHero(String name) {
        Cat cat = Cat.getInstance();
        cat.setName(name);
        return cat;
    }



    @Override
    public Level createLevel(int levelNumber) {
        EnemyBuilder enemyBuilder;
        LevelType levelType = getLevelType(levelNumber);


        switch (levelType) {
            case EASY:
                enemyBuilder = new MouseEnemyBuilder();
                return new Level(enemyBuilder, this, helper.getLastNames(levelNumber));
            case MEDIUM:
                enemyBuilder = new SkunkEnemyBuilder();
                return new Level(enemyBuilder, this, helper.getLastNames(levelNumber));
            case HARD:
                enemyBuilder = new SnakeEnemyBuilder();
                return new Level(enemyBuilder, this, helper.getLastNames(levelNumber));
        }
        enemyBuilder = new MouseEnemyBuilder();
        return new Level(enemyBuilder, this, helper.getLastNames(levelNumber));
    }

    @Override
    public void displayLevelInfo(int levelNumber) {
        LevelType levelType = getLevelType(levelNumber);
        System.out.println("\n\nOn to the next yard...\n\n");
        if(levelType == LevelType.HARD) {
            System.out.println("==|-|-| LEVEL " + levelNumber + " |-|-| BOSS FIGHT");
        } else if ( levelType == LevelType.MEDIUM) {
            System.out.println("==|-|-| LEVEL " + levelNumber + " |-|-| CHALLENGE FIGHT");
        } else {
            System.out.println("==|-|-| LEVEL " + levelNumber);
        }
        System.out.println("==|-|-| " + helper.getLastNames(levelNumber) + "'s backyard.");
    }

    @Override
    public void displayHeroInfo(int lives, int sneak) {
        System.out.println("Lives Remaining : " + lives);
        System.out.println("Sneak Skill     : " + sneak);
    }

    @Override
    public void combat(Cat cat, Enemy enemy) {
        while((cat.getLives() > 0 || cat.getHP() > 0) && enemy.getHP() > 0) {
            cat.attackEnemy(enemy);

            System.out.println();
            System.out.println("||====================");
            System.out.println("|| " + cat.getName() + " attacks the " + enemy.getName() + " and deals " + cat.claws.getDamage() + " damage." );
            System.out.println("||====================");
            enemy.attackCat(cat);
            System.out.println("|| " + enemy.getName() + " attacks " + cat.getName() + " and deals " + enemy.getAttack().getDamage() + " damage.");
            System.out.println("||====================");
            System.out.println("|| " + cat.getName() + " HP: " + cat.getHP());
            System.out.println("|| " + enemy.getName() + " HP: " + enemy.getHP());
            System.out.println("||====================");
            System.out.println();
        }
    }

    private LevelType getLevelType(int levelNumber) {
        if(levelNumber % 10 == 0 || levelNumber == MAX_ROUNDS) {
            return LevelType.HARD;
        } else if ( levelNumber % 5 == 0) {
            return LevelType.MEDIUM;
        } else {
            return  LevelType.EASY;
        }
    }


}
