/*-------------------------------------------------------------
// AUTHOR: Andronick Martusheff
// FILENAME: Lab6.java
// SPECIFICATION: Stores a record of group size and average scores.
// FOR: CSE 110- Lab #6
// TIME SPENT: ~ 3 Hours
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many students do you have?");
        int numStudents = scan.nextInt();
        int[] studentGroups = new int[numStudents]; // stored group #s from input
        double[] studentGrades = new double[numStudents]; // stored scores from input


        for (int i = 0; i < numStudents; i++) { // collects user input
            System.out.println("[Group #] and [Grade] for Entry " + (i + 1));
            int num1 = scan.nextInt();
            studentGroups[i] = num1;
            double num2 = scan.nextDouble();
            studentGrades[i] = num2;
        }

        System.out.println("==== List of Student Records ====");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Group " + studentGroups[i] + " - " + studentGrades[i] + " Points.");
        }

        int[] groupSizes = new int[getMax(studentGroups)];
        double[] groupAvg = new double[getMax(studentGroups)];

        for (int j = 1; j <= getMax(studentGroups); j++) { // iterates through # of groups
            double score = 0; // score for group resets for every iteration
            for (int i = 0; i < numStudents; i++) { // iterates through all recorded scores
                if (studentGroups[i] == j) {
                    groupSizes[j - 1] += 1; // stores group size
                    score = studentGrades[i];
                    groupAvg[j - 1] += score; // stores group average
                }
            }
        }


        System.out.println("\n==== Group Statistics ====");
        for (int i = 0; i < getMax(studentGroups); i++) {
            double avg = groupAvg[i] / groupSizes[i]; // determines average from arrays
            System.out.println("Group #" + (i + 1) + " has " + groupSizes[i] + " students, average is " + avg);
        }
    }

    public static int getMax(int[] inputArray) { // determines # of groups
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}
