package Support;
import java.util.ArrayList;
import java.util.Random;

public class Support {

    private ArrayList<String> lastNames = new ArrayList<String>();

    public String getLastNames(int levelNumber) {
        // Fun Fact, these are all different words for cats!
        lastNames.add("Puma");
        lastNames.add("Leontios");
        lastNames.add("Kahlikoe");
        lastNames.add("Apollo");
        lastNames.add("Leonidas");
        lastNames.add("Mouser");
        lastNames.add("Ekpen");
        lastNames.add("Gunju");
        lastNames.add("Kundam");
        lastNames.add("Areli");

        return lastNames.get(levelNumber % 10);
    }

    public int randInt(int min, int max) {
        Random random = new Random();
        int randomNum = random.nextInt((max - min)) + min;
        return randomNum;

    }


}
