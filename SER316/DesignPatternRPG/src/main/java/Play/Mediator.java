package Play;

import Enemy.Enemy;
import Enemy.Level;
import Hero.Cat;

public interface Mediator {
    public Cat createCatHero(String name);
    public Level createLevel(int levelNumber);
    public void displayLevelInfo(int levelNumber);
    public void displayHeroInfo(int lives, int sneak);
    public void combat(Cat cat, Enemy enemy);
}
