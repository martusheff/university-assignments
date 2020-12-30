//*********************************************************************************************
// CLASS: GradebookWriter (GradebookWriter.java)
//
// CSE205 Object Oriented Programming and Data Structures, Fall 2020
// Project Number: 3
// Author: Brennon Francis - bqfranci - bqfranci@asu.edu
// Author: Andronick Martusheff - aamartus - aamartus@asu.edu
//*********************************************************************************************

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GradebookWriter extends PrintWriter {

     //Implementation of GradeWriter constructor

     public GradebookWriter(String pFname) throws FileNotFoundException {

          super(pFname);

     }

     //Implementation of writeGradebook function
     //that Writes the gradebook info to the file,
     //which was opened in the ctor.

     public void writeGradebook(Roster pRoster) {

          for (Student student : pRoster.getStudentList()) {		//Iterate the loop

              println(student);

          }

     close();

     }
}