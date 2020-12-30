//*********************************************************************************************
// CLASS: Searcher (Searcher.java)
//
// CSE205 Object Oriented Programming and Data Structures, Fall 2020
// Project Number: 3
// Author: Brennon Francis - bqfranci - bqfranci@asu.edu
// Author: Andronick Martusheff - aamartus - aamartus@asu.edu
//*********************************************************************************************
import java.util.ArrayList;

public class Searcher {

     //Implementation of search function
     //search method to find the stdent by last name

     public static int search(ArrayList<Student> mStudentList, String pLastName) {

          for (int i = 0; i < mStudentList.size(); i++) {		//Iterate the loop

              if (mStudentList.get(i).getLastName().equals(pLastName)) {

                   return i;
              }
          }
          return -1;
     }
}