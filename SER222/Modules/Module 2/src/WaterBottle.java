interface BlueBottle {

    String color = "blue";
    int ounces = 16;

    void fillUp();
    void drinkWater();

    String isFilled();

}

public class WaterBottle implements BlueBottle {

    boolean isFilled;

    public static void main(String[] args) {
        System.out.println(color);
        WaterBottle myBottle = new WaterBottle();
        myBottle.drinkWater();
        myBottle.fillUp();
        myBottle.fillUp();
        myBottle.drinkWater();
        myBottle.drinkWater();
        myBottle.fillUp();
        System.out.println(myBottle.toString());

    }


    @Override
    public void fillUp() {
        if(this.isFilled == true) {
            System.out.println("Water bottle is already filled.");
            return;
        }
        this.isFilled = true;
        System.out.println("Water bottle has been filled.");
    }

    @Override
    public void drinkWater() {
        if(this.isFilled == false) {
            System.out.println("Cannot drink water, bottle is empty.");
            return;
        }
        this.isFilled = false;
        System.out.println("Drank water.");
    }

    @Override
    public String isFilled() {
        if(this.isFilled) {
            return "is filled";
        }
        return "is not filled";
    }

    @Override
    public String toString() {


        return "My water bottle is " + this.color + " and holds "
                + this.ounces + " ounces, and " + isFilled() + ".";
    }
}
