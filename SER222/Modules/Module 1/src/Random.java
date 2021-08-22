import java.util.Random;

class Dice {
    public static void main(String[] args) {
        Random dice = new Random();
        int number;

        for(int i = 1; i < 10; i++) {
            number = 1 + dice.nextInt(6);
            System.out.println("You rolled a " + number);
        }

    }
}
