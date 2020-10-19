/**
 * CLASS: H1_34 (H1_34.java)
 * GROUP 31
 * AUTHOR 1: Andronick Martusheff, aamartus, aamartus@asu.edu
 * AUTHOR 2: Brennon Francis, bqfranci, bqfranci@asu.edu
 */

import java.util.ArrayList;

public class H1_34 {

    public static void main(String[] args) {          //This is for the testing portion of this code
        ArrayList<Integer> pList = new ArrayList<>();   //Needs to be deleted before submission!
        for (int i = 1; i <= 5; i++) {                  //array length of 5
            pList.add(i);
        }
        System.out.println(arrayListSum(pList));
    }

    public static int arrayListSum(ArrayList<Integer> pList) {
        int sum = 0;
        if (pList == null) {
            return sum;
        } else {
            for (Integer i : pList) {                       //Enhanced loop
                sum += i;
            }
            return sum;
        }

    }   //end of method
}       //end of class
