/**
 * CLASS: H1_34 (H1_34.java)
 * GROUP 31
 * AUTHOR 1: Andronick Martusheff, aamartus, aamartus@asu.edu
 * AUTHOR 2: Brennon Francis, bqfranci, bqfranci@asu.edu
 */

import java.util.ArrayList;

public class H1_34 {

    public static int arrayListSum(ArrayList<Integer> pList) {
        int sum = 0;
        if (pList == null) {
            return sum;
        } else {
        for (Integer i : pList) {                       
                sum += i;
            }
        return sum;
        }
    }   
}      