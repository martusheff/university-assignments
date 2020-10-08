// AUTHOR: Andronick Martusheff
// FILENAME: Lab3.java
// SPECIFICATION: determines whether or not a student has passed a class
// FOR: CSE 110- Lab #3
// TIME SPENT: ~80 Minutes (differentiating Java from the Python I already know is challenging)
//-----------------------------------------------------------*/

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {

        // scanner for user input
        Scanner input = new Scanner(System.in);

        // initializing variables
        double homework = 0;
        double midterm = 0;
        double final_exam = 0;
        double total = 0;
        int i = 0; // variable used for conditional WHILE loop
        int f = 0; // variable used for exiting program when 3 errors occur

        // specified decimal format set
        NumberFormat hund = new DecimalFormat("#0.00");

        //conditional while loop (all program logic is essentially contained within it)
        while (i < 4) {
            if (i == 0) { //conditional test for homework
                System.out.print("Enter your HOMEWORK grade: ");
                homework = input.nextInt();
                if (homework >= 0 && homework <= 100) {
                    i += 1;
                } else {
                    System.out.println("[ERR] Invalid input. A homework grade should be in [0, 100].");
                    i = 0;
                    f += 1;
                    if (f == 3) {
                        System.out.println("[ERR] You have retried 3 times. Please restart your program.");
                        i = 4;
                    }
                }
            }
            if (i == 1) { // conditional test for midterm
                System.out.print("Enter your MIDTERM grade: ");
                midterm = input.nextInt();
                if (midterm >= 0 && midterm <= 100) {
                    i += 1;
                } else {
                    System.out.println("[ERR] Invalid input. A midterm grade should be in [0, 100].");
                    i = 1;
                    f += 1;
                    if (f == 3) {
                        System.out.println("[ERR] You have retried 3 times. Please restart your program.");
                        i = 4;
                    }
                }
            }
            if (i == 2) { // conditional test for final exam
                System.out.print("Enter your FINAL EXAM grade: ");
                final_exam = input.nextInt();
                if (final_exam >= 0 && final_exam <= 200) {
                    i += 1;

                } else {
                    System.out.println("[ERR] Invalid input. A final grade should be in [0, 200].");
                    i = 2;
                    f += 1;
                    if (f == 3) {
                        System.out.println("[ERR] You have retried 3 times. Please restart your program.");
                        i = 4;
                    }
                }

            }
            if (i == 3) { // conditional final step. once reached, program will display output and exit.
                total = (final_exam / 200 * 50) + (midterm * .25) + (homework * .25);
                if (total >= 50) {
                    System.out.println("[INFO] Student's Weighted Total is " + hund.format(total));
                    System.out.println("[INFO] Student PASSED the class");
                    i += 1;
                } else {
                    System.out.println("[INFO] Student's Weighted Total is " + hund.format(total));
                    System.out.println("[INFO] Student FAILED the class");
                    i += 1;
                }
            }
        }
    }
}


