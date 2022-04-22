package Hero;

import Enemy.Enemy;
import Support.Support;

public class Cat {

    private String name;
    public Claws claws = new Claws();
    public Type type;

    private int lives = 9;
    private int sneak = 0;
    private int HP;
    

    
    public enum Type {
        TIGER("Tiger"),
        CARACAL("Caracal"),
        SPHYNX("Sphynx");

        private final String name;

        private Type(String s) {
            name = s;
        }

        public String toString() {
            return this.name;
        }

        public int getStartingHP() {
            switch(this) {
                case TIGER:
                    return 40;
                case CARACAL:
                    return 20;
                case SPHYNX:
                    return 10;
            }
            return 20;
        }

    }


    static Cat cat = new Cat();

    private Cat() {
        System.out.println("Creating your new cat hero!");
        setUpCharacter();
    }



    public static Cat getInstance() {
        return cat;
    }

    public void setName(String name) {
        if(cat.name == null) {
            System.out.println("Happy hunting, " + name + "! >:)\n");
        } else {
            System.out.println("Smart, keep them guessing! Name changed to: " + name + "!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLives() {
        return lives;
    }

    public void takeHit(int damage) {
        HP -= damage;

        if(HP <= 0) {
            lives--;
            HP = type.getStartingHP();
        }
    }

    public void attackEnemy(Enemy enemy) {
        enemy.takeHit(claws.getDamage());
    }

    public int getHP() {
        return HP;
    }
    public int getSneak() {
        return sneak;
    }


    private void setUpCharacter() {
        Support helper = new Support();
        int randomNum = helper.randInt(1,4);

        // Starting Character Randomizer

        if(randomNum == 1) { // TIGER CLASS SELECTED
            this.HP = 40;
            this.sneak = 1;
            this.type = Type.TIGER;
        } else if (randomNum == 2) { // CALICO CLASS SELECTED
            this.HP = 20;
            this.sneak = 9;
            this.type =  Type.CARACAL;
        } else { // SPHYNX CLASS SELECTED
            this.HP = 10;
            this.sneak = 15;
            this.type = Type.SPHYNX;
        }

        System.out.println("The '" + this.type.toString() + "' cat class has been selected for you.");
    }

}
