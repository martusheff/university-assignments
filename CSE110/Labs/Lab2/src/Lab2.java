/*-------------------------------------------------------------
// AUTHOR: Andronick Martusheff
// FILENAME: Lab2.java
// SPECIFICATION: Stores and displays user input and input length.
//                Example of if-statement used in context to Lab02 commented out in bottom.
// FOR: CSE 110 - Lab #2
// TIME SPENT: 32 Minutes
//-----------------------------------------------------------*/

// importing input scanner

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {

        /// declaring variables before hand
        String first_name = "";
        String last_name = "";
        String full_name = "";
        int name_length = 0;
        Scanner scan = new Scanner(System.in);

        // asking user for input
        System.out.print("Enter your first name: ");
        first_name = scan.nextLine();
        System.out.print("Enter your last name: ");
        last_name = scan.nextLine();

        // combining first and last name, and outputting in UPPER case
        full_name = first_name + " " + last_name;
        System.out.println("Full name (in capitals): " + full_name.toUpperCase());

        // using the '.length()' method to determine length of name (space included)
        name_length = full_name.length();
        System.out.println("Length of full name: " + name_length);

        //checking if the '==' sign works
        if (first_name == last_name) {
            System.out.println("String comparison using \"==\" sign works");
        } else {
            System.out.println("String comparison using \"==\" does NOT work");
        }

        //checking if the '.equals' string method works
        if (first_name.equals(last_name)) {
            System.out.println("String comparison using the \"equals\" method works");
        } else {
            System.out.println("String comparison using the \"equals\" method does NOT work");
        }


        /*----------------------------------------------------------
        /*---- EXAMPLE OF '.EQUALS' USED IN PRACTICE  --------------
        /*----------------------------------------------------------
        if (first_name.equals(last_name)) {
            System.out.println("First and last names are identical");
        } else {
            System.out.println("First and last names are different");
        }
        //-------------------------------------------------------- */
    }
}
