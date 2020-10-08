// CSE 110     : CSE110 - Session a
// Assignment  : Assignment4.java
// Author      : Andronick Martusheff - 1219284898
// Description : Guess a 4 digit number.

// Note        : My submitted program wasn't written to be as short as possible. There are areas where I could've
//             : considerably cut down the code, but transitioning from python, I wanted to implement as much java
//             : as I reasonably could. I tried to incorporate pre-written methods from other labs as well. I'm not
//             : sure if my "public static" definitions were appropriate, it was the only way I currently know how
//             : to make the variables accessible to multiple methods. Thank you for your time.


// imported java utilities used in program

import java.util.Scanner; // takes user input
import java.util.Random; // generates random number

public class Assignment4 {

    public static String answer; // the 4 digit number a user tries to find
    public static String guess; // the 4 digit guess a user inputs
    public static int i, j, n, r;
    public static Scanner scan;
    public static char BORDER_SYMB = '-'; // set styling for program titles---/
    public static int BORDER_WIDTH = 5; // ----------------------------------/

    public static void main(String[] args) {
        i = 1; // tracks # of guesses
        j = 0; // conditional var which determines whether or not the program runs
        r = 1; // shows round number for user who wants to play again.
        String mastermind = buildRow(BORDER_WIDTH, "mastermind", BORDER_SYMB); // builds title row
        System.out.println(mastermind);
        System.out.println("Guess the 4 digit number!");
        System.out.println("(Enter 'q' at any time to quit)\n");

        System.out.println(buildRow(BORDER_WIDTH, "round " + r, BORDER_SYMB) + "\n");
        answer = randomNum();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Guess " + i + ": ");
            guess = scan.nextLine();

            if (checkLength(guess.length())) { // primary test case
                i++;
                int correct = checkMatch(); // checks how many numbers were matches
                System.out.println("You matched " + correct); // outputs # correct
                System.out.print("\n");

                if (correct == 4) { // final test case, determines if user would like to continue playing
                    System.out.println("Congratulations! You guessed the right number in " + (i - 1) + " guess(es).");
                    System.out.println("Would you like to play again (yes/no)");
                    String play = scan.nextLine();
                    if (playAgain(play)) { // the user would like to keep playing
                        System.out.println("Great! Let's find you a new number.");
                        System.out.print("\n");
                        r++;
                        System.out.println(buildRow(BORDER_WIDTH, "round " + r, BORDER_SYMB) + "\n");
                        i = 1; // resets guesses variable
                        answer = randomNum(); // generates new number to be guessed
                    } else { // the user is done playing
                        System.out.println("Thanks for playing, goodbye!");
                        j = 1; // tells main loop to end
                    }
                }

            } else if (guess.equals("q")) { // user quit option
                System.out.println("Better luck next time!");
                j = 1;

            } else { // asks user for a strict 4 digit input
                System.out.println("Please provide a 4 digit guess.");
            }

        } while (j != 1); // program will continue to run unless condition 'j=1' met
    }

    private static String randomNum() { // generates random number
        Random random = new Random(); // creates random instance
        String generateNum = String.format("%04d", random.nextInt(10000)); // string formatted (leading 0s)
        return generateNum;
    }

    private static int checkMatch() { // checks for matches between 'guess' and 'answer'
        n = 0; // resets matches to 0 for each new guess
        if (answer.charAt(0) == guess.charAt(0)) // X000
            n++; // if true, add 1 to n
        if (answer.charAt(1) == guess.charAt(1)) // 0X00
            n++;
        if (answer.charAt(2) == guess.charAt(2)) // 00X0
            n++;
        if (answer.charAt(3) == guess.charAt(3)) // 000X
            n++;

        return n;

    }

    private static boolean playAgain(String play) { // check if user wants to play again
        if (play.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkLength(int guess) { // unnecessary, just practicing method calls here
        if (guess == 4) {
            return true;
        } else {
            return false;
        }
    }

    private static String buildRow( // builds uniform title rows
                                    int BORDER_WIDTH, String title, char BORDER_SYMB) {
        String row = "";

        for (int i = 0; i < BORDER_WIDTH; i++) {
            row += BORDER_SYMB;
        }
        row += " " + title.toUpperCase() + " ";

        for (int i = 0; i < BORDER_WIDTH; i++) {
            row += BORDER_SYMB;
        }
        return row;
    }
}