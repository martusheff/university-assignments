/**
 * CLASS: H1_31 (H1_31.java)
 * GROUP 31
 * AUTHOR 1: Andronick Martusheff, aamartus, aamartus@asu.edu
 * AUTHOR 2: Brennon Francis, bqfranci, bqfranci@asu.edu
 */

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class H1_31 {
    
    public H1_31() {                                    //default constructor
    }

    public static ArrayList<Integer> arrayListInit(){   //arrayListInit method
        ArrayList<Integer> list = new ArrayList<>();        
        int j = 0;                                          
        while(j < 2) {                                  //While and For loops used to assign
            for (int i = 0; i < 5; i++) {               //numbers to the created array.
                if(j == 0){
                    list.add(i, i);
                } else {
                    list.add(i + 5, i);
                }
            }
            j++;
        }
        return list;
    }
}
