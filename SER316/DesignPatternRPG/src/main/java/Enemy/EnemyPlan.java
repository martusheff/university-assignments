package Enemy;

import Hero.Cat;

public interface EnemyPlan {
    public void setAttack(Attack attack);
    public void setHP(int HP);
    public String getName();
    public int getHP();
    public void attackCat(Cat cat);
    public void takeHit(int damage);
}
