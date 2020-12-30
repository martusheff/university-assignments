//*********************************************************************************************
// CLASS: Sorter (Sorter.java)
//
// CSE205 Object Oriented Programming and Data Structures, Fall 2020
// Project Number: 3
// Author: Brennon Francis - bqfranci - bqfranci@asu.edu
// Author: Andronick Martusheff - aamartus - aamartus@asu.edu
//*********************************************************************************************
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Sorter {											
	//Implementation of sort method
    //sort method to sort the student by last name

     public static ArrayList<Student> sort(ArrayList<Student> mStudentList) {

          Collections.sort(mStudentList, new Comparator<Student>() {

              //used the comparator class to sort the student by their last name

              @Override

              //Implementation of compare function

              public int compare(Student o1, Student o2) {

                   return o1.getLastName().compareTo(o2.getLastName());

              }
          });

     return mStudentList;

     }

}