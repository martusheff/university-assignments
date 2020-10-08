/*------------------------------------------------------------
// AUTHOR: ANDRONICK MARTUSHEFF
// FILENAME: Lab1.java
// SPECIFICATION: CALCULATING AVERAGE OF 3 SCORES FROM USER INPUT
// FOR: CSE 110- Lab #1
// TIME SPENT: ~25 MINUTES //---------------------------------
---------------------------------------*/

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        int test_1, test_2, test_3; // declaring the variables for the
        final int NUM_TESTS = 3; // constant (# of scores)

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the score on the first test: "); // prompt for integer input
        test_1 = input.nextInt(); // test_# will be populated by input integer
        System.out.print("Enter the score on the second test: ");
        test_2 = input.nextInt();
        System.out.print("Enter the score on the third test: ");
        test_3 = input.nextInt();

        double score_avg = (test_1 + test_2 + test_3) / (double) NUM_TESTS; // calculating average, casting NUM_TESTS


        System.out.printf("Your average score is: " + "%.4f", score_avg); //printing out average of 3 scores

    }
}
