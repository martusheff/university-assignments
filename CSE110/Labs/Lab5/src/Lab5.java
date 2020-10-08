/*-------------------------------------------------------------
// AUTHOR: Andronick Martusheff
// FILENAME: Lab5.java
// SPECIFICATION: Display a menu that builds specified patterns based on user input.
// FOR: CSE110 (Session A)
// TIME SPENT: ~ 3 Hours (Coded along with the solution, spent time reading the code.)
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) {

        // declaring & initializing variables
        final char SIDE_SYMB = '-';
        final char MID_SYMB = '*';
        char choice = ' ';
        String strToChar = "";
        int sideWidth = -1, midWidth = -1, numSymbols = -1;
        Scanner scan = new Scanner(System.in);

        // main loop program operates in
        do {
            printMenu();
            strToChar = scan.nextLine();
            if (strToChar.length() > 0) {
                choice = strToChar.charAt(0);
            } else {
                choice = ' ';
            }

            switch (choice) {
                case 'r':
                    System.out.println("Width of sides?");
                    sideWidth = scan.nextInt();
                    System.out.println("Width of the middle?");
                    midWidth = scan.nextInt();

                    System.out.println(buildRow(
                            SIDE_SYMB, MID_SYMB, sideWidth, midWidth));
                    scan.nextLine(); // clears scanner

                    break;

                case 'p':
                    System.out.println("Number of symbols on the lowest layer?");
                    numSymbols = scan.nextInt();

                    System.out.println(buildPyramid(
                            SIDE_SYMB, MID_SYMB, numSymbols));
                    scan.nextLine();

                    break;

                case 'd':
                    System.out.println("Number of symbols on the middle layer?");
                    numSymbols = scan.nextInt();

                    System.out.println(buildDiamond(
                            MID_SYMB, numSymbols));
                    scan.nextLine();

                    break;

                case 'q':
                    System.out.println("Bye");
                    break;
            }
        } while (choice != 'q');
        scan.close();
    }

    // row building method
    private static String buildRow(
            char sideSymb, char midSymb, int sideWidth, int midWidth) {
        String row = "";

        for (int i = 0; i < sideWidth; i++) {
            row += sideSymb;
        }
        for (int i = 0; i < midWidth; i++) {
            row += midSymb;
        }
        for (int i = 0; i < sideWidth; i++) {
            row += sideSymb;
        }
        return row;

    }

    // pyramid building method
    private static String buildPyramid(
            char sideSymb, char midSymb, int numSymbols) {
        String pyramid = "";

        int symbLimit = numSymbols;

        for (int numStars = 1; numStars <= numSymbols; numStars += 2) {
            int numDashes = (symbLimit - numStars) / 2;
            String row = buildRow(sideSymb, midSymb, numDashes, numStars);
            pyramid += row + "\n";
        }
        return pyramid;
    }

    // diamond building method
    private static String buildDiamond(
            char starSymb, int numWidth) {
        String diamond = "";
        char charSpace = ' ';
        System.out.println();
        numWidth = numWidth / 2;
        int i, x = 0;

        // top half of diamond
        for (i = 0; i < numWidth; i++) {
            for (x = i; x < numWidth; x++) // left
                diamond += starSymb;
            for (x = 0; x < 2 * i + 1; x++) // center
                diamond += charSpace;
            for (x = i; x < numWidth; x++) // right
                diamond += starSymb;
            diamond += "\n"; // moves to next line
        }

        // bottom half of diamond
        for (i = 0; i < numWidth - 1; i++) {
            for (x = 0; x < i + 2; x++) //left
                diamond += starSymb;
            for (x = 0; x < 2 * (numWidth - 1 - i) - 1; x++) // center
                diamond += charSpace;
            for (x = 0; x < i + 2; x++) // right
                diamond += starSymb;
            diamond += "\n"; // moves to next line
        }
        return diamond;
    }

    // simple menu for main loop
    private static void printMenu() {
        System.out.println("Please choose one pattern from the list:");
        System.out.println("r) Row");
        System.out.println("p) Pyramid");
        System.out.println("d) Diamond");
        System.out.println("q) Quit");

    }
}

