package Enemy;

import Hero.Cat;

public class Enemy implements EnemyPlan {

    private Attack attack;
    private int HP;
    protected String name;

    @Override
    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public Attack getAttack() {
        return attack;
    }

    public void attackCat(Cat cat) {
        cat.takeHit(attack.getDamage());
    }

    public void takeHit(int damage) {
        HP -= damage;
    }

}
