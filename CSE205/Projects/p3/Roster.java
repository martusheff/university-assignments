//*********************************************************************************************
// CLASS: Roster (Roster.java)
//
// CSE205 Object Oriented Programming and Data Structures, Fall 2020
// Project Number: 3
// Author: Brennon Francis - bqfranci - bqfranci@asu.edu
// Author: Andronick Martusheff - aamartus - aamartus@asu.edu
//*********************************************************************************************


import java.util.ArrayList;

public class Roster {										//Declaration of Roster class

     private ArrayList<Student> mStudentList;				// Declare mStudentList as type Student
    
     public Roster() {										//Implementation of Default constructor

          mStudentList = new ArrayList<>();
          setStudentList(mStudentList);
          
     }

     public void addStudent(Student pStudent) {				//Implementation of addStudent function
          mStudentList.add(pStudent);						//which Add student to the list
          
     }

     public Student getStudent(String pLastName) {			//Implementation of getStudent function

          int index = Searcher.search(getStudentList(), pLastName);	//Get a student by calling searcher

          if (index == -1) {

              return null;

          } else {
        	  
              return mStudentList.get(index);
          }
     }

     public ArrayList<Student> getStudentList() {			//Accessor method for StudentList 
          return mStudentList;

     }

     private void setStudentList(ArrayList<Student> pStudentList) {	//Implementation of setStudentList function
          mStudentList = pStudentList;

     }

     public void sortRoster() {								//Implementation of sortRoster function
          Sorter.sort(mStudentList);

     }

     @Override
     public String toString() {								//Implementation of toString function
          String result = "";
          for (Student student : getStudentList()) {		//Iterate the loop
              result += student + "\n";
          }
          return result;
     }
}