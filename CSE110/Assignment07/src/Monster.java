public class Monster {
    String name;
    int healthScore;
    Weapon weapon = new Weapon();

    public Monster(String name, int healthScore, Weapon weapon){
        this.name = name;
        this.healthScore = healthScore;
        this.weapon = weapon;

    }

    public String getName(){
        return name;
    }
    public int getHealthScore(){
        return healthScore;
    }
    public String getWeaponName(){
        return weapon.name;
    }
    public int attack(Monster monster){
        int attack = (int) (Math.random() * monster.weapon.maxDamage);
        monster.healthScore -= attack;
        return attack;
    }
}

