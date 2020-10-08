public class Weapon {
    String name;
    int maxDamage;

    public Weapon(){
        this.name = "Pointy Stick";
        this.maxDamage = 1;
    }
    public Weapon(String name, int maxDamage){
        super();
        this.name = name;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }



}
