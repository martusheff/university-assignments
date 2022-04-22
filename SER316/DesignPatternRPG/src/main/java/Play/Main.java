package Play;

import Enemy.*;
import Hero.Cat;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Creating the Game Play.Mediator
        GameMediator gmed = new GameMediator();

        // Creating the Singleton Pattern Hero.Cat Hero
        Cat catHero = gmed.createCatHero("Vladimir");



        for(int i = 1; i <= gmed.MAX_ROUNDS; i++) {
            Thread.sleep(gmed.TICK_RATE);

            gmed.displayLevelInfo(i);
            Level level = gmed.createLevel(i);
            level.constructEnemy();
            Enemy enemy = level.getEnemy();

            gmed.combat(catHero, enemy);

            if(catHero.getLives() < 0) {
                return;
            }


            gmed.displayHeroInfo(catHero.getLives(), catHero.getSneak());
            System.out.println();

        }

        System.out.println("\n\n\n");

        if(catHero.getLives() > 0) {
            System.out.println("Congratulations, " + catHero.getName() + ", you have conquered the neighborhood!");
        } else {
            System.out.println("Rest in piece, " + catHero.getName() + ". :(");
        }

        System.out.println("\nGAME OVER.");

    }
}
