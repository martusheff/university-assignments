//*********************************************************************************************
// CLASS: Main (Main.java)
//
// CSE205 Object Oriented Programming and Data Structures, Fall 2020
// Project Number: 3
// Author: Brennon Francis - bqfranci - bqfranci@asu.edu
// Author: Andronick Martusheff - aamartus - aamartus@asu.edu
//*********************************************************************************************

import javax.swing.JFrame;
import java.io.FileNotFoundException;

public class Main {								//Implementation of Main class

   private static Roster mRoster;				// The Roster of students that is read from "gradebook.txt".   
   private static View mView;					// A reference to the View object.
   public static int NUM_EXAMS = 3;
   public static int NUM_HOMEWORKS = 5;
   

   public static void main(String[] pArgs) {	//Implementation of main function

       new Main().run();

   }

   //Implementation of exit function
   //which Exits the program when the
   //exit button is clicked

   public static void exit() {

       try {

           GradebookWriter gradeBookWriter = new GradebookWriter("gradebook.txt");
           gradeBookWriter.writeGradebook(getRoster());
           System.exit(0);
           gradeBookWriter.close();
           
       } catch (FileNotFoundException pException) {

           getView().messageBox("Could not open gradebook.txt for writing. Exiting without saving.");
           System.exit(-1);
           
       }
   }
   
   /**
    * This method returns the number of exams in the class by returning the constant NUM_EXAMS.
    */
   public static final int getNumExams() {
       return NUM_EXAMS;
       
   }

   /**
    * This method returns the number of homework assignments in the class by returning the
    * constant NUM_HOMEWORKS.
    */
   public static final int getNumHomeworks() {
       return NUM_HOMEWORKS;
       
   }

   private static Roster getRoster() {			//Implementation of getRoster function
	   
       return mRoster;
       
   }
 
   private void setRoster(Roster pRoster) {		//Implementation of setRoster function

       mRoster = pRoster;

   }

   private static View getView() {				//Implementation of getView function

       return mView;

   }
 
   private void setView(View pView) {			//Implementation of setView function

       mView = pView;

   }

   //Implementation of run function
   //which run() is the main routine.

   private void run() {

       JFrame.setDefaultLookAndFeelDecorated(false);

       setView(new View(this));

       try {

           GradebookReader gbReader = new GradebookReader("gradebook.dat");
           setRoster(gbReader.readGradebook());
           mRoster = getRoster();

       } catch (FileNotFoundException pException) {

           getView().messageBox("Could not open gradebook.dat for reading. Exiting.");
           System.exit(-1);

       }
   }

   // Implementation of search function
   // which is called when the search button is clicked

   public static Student search(String pLastName) {
       return getRoster().getStudent(pLastName);
   }
} 