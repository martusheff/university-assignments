package Hero;

public class Claws {
    int damage;
    String name;

    public Claws() {
        this.damage = 5;
        this.name = "Declawed";
    }

    public Claws(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
