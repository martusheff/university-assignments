//**************************************************************************************************
// CLASS: Student
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// (c) Kevin R. Burger 2014-2019
//**************************************************************************************************
//package proj3;

import java.util.ArrayList;

public class Student implements Comparable<Student> {			//Implementation of Student class

	 
     private ArrayList<Integer> mExamList;
     private static String mFirstName;
	private static String mLastName;
     private ArrayList<Integer> mHomeworkList;
     static Student mCurrStudent = new Student(mLastName, mFirstName);

     public Student(String pFirstName, String pLastName) {		//Implementation of parameterized constructor

          mFirstName = pFirstName;
          mLastName = pLastName;
          mExamList = new ArrayList<Integer>();
          mHomeworkList = new ArrayList<Integer>();
          
          
     }


     public void addExam(int pScore) {							//Implementation of addExam function
          getExamList().add(pScore);

     }

     public void addHomework(int pScore) {						//Implementation of addHomework function
          getHomeworkList().add(pScore);

     }

     public int compareTo(Student pStudent) {					//Implementation of compareTo function

          int ret = 0;

          if (this.getLastName().length() < pStudent.getLastName().length()) {
              ret = -1;
          }
          if (this.getLastName().length() == pStudent.getLastName().length()) {
        	  ret = 0;
          }
          if (this.getLastName().length() > pStudent.getLastName().length()) {
              ret = 1;
          }
          return ret;
     }
     
     /**
      * Accessor method for mCurrStudent.
      */ 
     public static Student getCurrStudent() {
         return mCurrStudent;
     }

     public int getExam(int pNum) {								//Implementation of getExam function
          return getExamList().get(pNum);

     }

     protected ArrayList<Integer> getExamList() {				//Should be set to "Private"
          return mExamList;

     }

     public String getFirstName() {								//Implementation of getFirstName function
          return mFirstName;

     }
     
     public String getFullName() {
    	 String fullname = mLastName + ", " + mFirstName;
    	 return fullname;
     }

     public int getHomework(int pNum) {							//Implementation of getHomework function
          return getHomeworkList().get(pNum);

     }

     protected ArrayList<Integer> getHomeworkList() {			//Should be set to "Private"
          return mHomeworkList;

     }

     public String getLastName() {								//Implementation of getLastName function
          return mLastName;

     }
     
     /**
      * Mutator method for mCurrStudent.
      */ 
     public static void setCurrStudent(Student pCurrStudent) {
         mCurrStudent = pCurrStudent;
     }

     public void setExam(int pNum, int pScore) {				//Implementation of setExam function
          getExamList().set(pNum, pScore);

     }

     protected void setExamList(ArrayList<Integer> pExamList) {	//Should be set to "Private"
          mExamList = pExamList;

     }

     public void setFirstName(String pFirstName) {				//Implementation of setFirstName function
          mFirstName = pFirstName;

     }

     public void setHomework(int pNum, int pScore) {			//Implementation of setHomework function
          getHomeworkList().set(pNum, pScore);

     }

     protected void setHomeworkList(ArrayList<Integer> pHomeworkList) {	//Should be set to "Private"
          mHomeworkList = pHomeworkList;

     }

     public void setLastName(String pLastName) {				//Implementation of setLastName function
          mLastName = pLastName;

     }
     
     @Override
     public String toString() {
         String result = getLastName() + " " + getFirstName() + " ";
         for (Integer exam : getExamList()) {
             result += exam + " ";
         }
         for (Integer hw : getHomeworkList()) {
             result += hw + " ";
         }
         return result.trim();
     }
     
     
     
     
}