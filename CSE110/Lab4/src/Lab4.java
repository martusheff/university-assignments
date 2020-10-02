/*-------------------------------------------------------------
// AUTHOR: Andronick Martusheff
// FILENAME: Lab4.java
// SPECIFICATION: program menu that performs 3 different arithmetic operations.
// FOR: CSE 110- Lab #4
// TIME SPENT: ~ 80 minutes.
//-----------------------------------------------------------*/


import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        int choice = 1;
        Scanner scan = new Scanner(System.in);
        String prompt = "Enter a number:";

        // loop containing test cases
        do {
            printMenu();
            choice = scan.nextInt();

            switch (choice) {
                case 1:

                    System.out.println(prompt);
                    int m = scan.nextInt();
                    System.out.println("The sum of 1 to " + m + " is " + checkSum(m));
                    System.out.println();
                    break;

                case 2:

                    System.out.println(prompt);
                    m = scan.nextInt();
                    System.out.println("The factorial of " + m + " is " + factorial(m));
                    System.out.println();
                    break;

                case 3:

                    System.out.println(prompt);
                    m = scan.nextInt();
                    System.out.println("The leftmost digit of " + m + " is " + checkLeftmost(m));
                    System.out.println();
                    break;
            }


        } while (choice != 4);
        System.out.println("Bye");
    }

    // method checking sum from number 1 to m
    static int checkSum(int m) {
        int result = 0;
        for (int i = 1; i <= m; i++) {
            result += i;
        }
        return result;
    }

    // method checking factorial of int m
    static int factorial(int m) {
        int result = 1;
        for (int i = 2; i <= m; i++)
            result *= i;
        return result;
    }

    // method checking leftmost number from in m
    static int checkLeftmost(int m) {
        while (m > 10) // while m > 10
            m = m / 10; // divide by 10. leaves leftmost digit unchanged.
        return m;


    }

    private static void printMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1) Calculate the sum of integers from 1 to m");
        System.out.println("2) Calculate the factorial of a given number");
        System.out.println("3) Display the leftmost digit of a given number");
        System.out.println("4) Quit");
    }

}
