/**
 * CLASS: H1_35 (H1_35.java)
 * GROUP 31
 * AUTHOR 1: Andronick Martusheff, aamartus, aamartus@asu.edu
 * AUTHOR 2: Brennon Francis, bqfranci, bqfranci@asu.edu
 */

import java.util.ArrayList;

public class H1_35 {
    
    public H1_35() {                                                    //default constuctor
    }

    public static ArrayList<Integer> arrayListCreate(int pLen, int pInitValue) {

        ArrayList<Integer> list = new ArrayList<>();                    //pLen = length of array
        if (pLen == 0) {                                                //pInitValue = # for elements
            return null;                                                
        } else {
            for (int i = 0; i < pLen; i++) {                            //For loop used to create array
                list.add(i, pInitValue);                                
            }
        }
        return list;
    }
}
