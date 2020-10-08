// CSE 110     : Online A
// Assignment  : Assignment01.java
// Author      : Andronick Martusheff - 1219284898
// Description : Determining share of pizza at a party.

import java.util.Scanner;

public class Assignment01 {
    public static void main(String[] args) {

        // declaring initial variables, scanner
        int num_pizzas, slices_per, num_adults, num_children;
        Scanner input = new Scanner(System.in);

        // taking user input, string formatted
        System.out.printf("%-26s %s", "Number of pizzas purchased", ": "); // prompt for integer input
        num_pizzas = input.nextInt(); // test_# will be populated by input integer
        System.out.printf("%-26s %s", "Number of slices per pizza", ": ");
        slices_per = input.nextInt();
        System.out.printf("%-26s %s", "Number of adults", ": ");
        num_adults = input.nextInt();
        System.out.printf("%-26s %s", "Number of children", ": ");
        num_children = input.nextInt();

        // declaring variables for output, determining share
        int total_slices = slices_per * num_pizzas;
        int for_adults = num_adults * 2;
        int for_children = total_slices - for_adults;
        int per_child = for_children / num_children;
        int leftover = for_children % num_children;


        // formatted output of share to user
        System.out.printf("%-45s %s %n", "Total number of slices of pizza", ": " + total_slices);
        System.out.printf("%-45s %s %n", "Total number of slices given to adults", ": " + for_adults);
        System.out.printf("%-45s %s %n", "Total number of slices available for children", ": " + for_children);
        System.out.printf("%-45s %s %n", "Number of slices each child will get", ": " + per_child);
        System.out.printf("%-45s %s %n", "Number of slices left over", ": " + leftover);


    }


}
