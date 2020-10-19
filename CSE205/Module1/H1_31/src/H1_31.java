/**
 * CLASS: H1_31 (H1_31.java)
 * GROUP 31
 * AUTHOR 1: Andronick Martusheff, aamartus, aamartus@asu.edu
 * AUTHOR 2:
 */

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class H1_31 {

    public static void main(String[] args) {

        System.out.println(arrayListInit());
    }

    public static ArrayList<Integer> arrayListInit(){
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        while(j < 2) {
            for (int i = 0; i < 5; i++) {
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
