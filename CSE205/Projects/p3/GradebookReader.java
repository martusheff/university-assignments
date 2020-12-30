//*********************************************************************************************
// CLASS: GradebookReader (GradebookReader.java)
//
// CSE205 Object Oriented Programming and Data Structures, Fall 2020
// Project Number: 3
// Author: Brennon Francis - bqfranci - bqfranci@asu.edu
// Author: Andronick Martusheff - aamartus - aamartus@asu.edu
//*********************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

	public class GradebookReader {								//Implementation of GradebookReader class

     private Scanner mIn;										//Declare mIn as type of scanner object

     /**
     * Attempts to open the gradebook file for reading.
     * If successful, mIn will be used to read from the file.
     * If the file
     * cannot be opened, a FileNotFoundException will be thrown.
     */

     public GradebookReader(String pFname) throws FileNotFoundException {		//Implementation of parameterized constructors
          mIn = new Scanner(new File(pFname));
     }

     /**
     * Reads the exam scores for a Student.
     */
     private void readExam(Student pStudent) {					//Implementation of readExam function

          for (int n = 0; n < Main.getNumExams(); ++n) {	//Iterate the loop

              pStudent.addExam(mIn.nextInt());

          }
     }

     /**
     * Called to read the gradebook information.
     * Calls readRoster() to read the student records
     * and then sorts the roster
     * by last name.
     */

     public Roster readGradebook() {			 				//Implementation of readGradebook function

          Roster roster = readRoster();							//Create an object for Roster class
          roster.sortRoster();									//call sortRoster function

          return roster;
          
     }

     /**
     * Reads the homework scores for a Student.
     */

     private void readHomework(Student pStudent) {				//Implementation of readHomework function

          for (int n = 0; n < Main.getNumHomeworks(); ++n) {	//Iterate the loop

          pStudent.addHomework(mIn.nextInt());

          }
     }

     /**
     * Reads the student information from the
     * input file adding Student objecs to the roster.
     */

     private Roster readRoster() {								//Implementation of readRoster function
    	 
          Roster roster = new Roster();							//Create an object for Roster class

          while (mIn.hasNext()) {								//Iterate the loop

              String lastName = mIn.next();
              String firstName = mIn.next();

              Student student = new Student(firstName, lastName);	//Create an object for Student class

              readHomework(student);

              readExam(student);

              roster.addStudent(student);
          }
          return roster;
     }
}