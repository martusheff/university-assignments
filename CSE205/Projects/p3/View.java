//**************************************************************************************************
// CLASS: View
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// (c) Kevin R. Burger 2014-2019
//**************************************************************************************************

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* The View class implements the GUI.
*/

public class View extends JFrame implements ActionListener {			

   public static final long serialVersionUID = 1L; 
   public static final int FRAME_WIDTH = 500;
   public static final int FRAME_HEIGHT = 250;

   private JButton mClearButton, mExitButton, mSaveButton, mSearchButton;	// instance variables
   private JTextField[] mExamText, mHomeworkText;
   private JTextField mSearchText;
   private Main mMain;
   private Student mStudent;

   /**
   * View()
   *
   * The View constructor creates the GUI interface and makes the frame
   * visible at the end.
   */

   public View(Main pMain) {								//parameterized constructor

       // Save a reference to the Main object pMain in mMain.
	   setMain(pMain);

	   // PSEUDOCODE:
       // Create a JPanel named panelSearch which uses the FlowLayout
       // Add a JLabel "Student Name: " to panelSearch
       // Create mStudentName and make the field 25 cols wide
       // Add mStudentName to the panel
       // Create mSearchButton with the label "Search"
       // Make this View the action listener for the button
       // Add the button to the panel

       JPanel panelSearch = new JPanel(new FlowLayout());

       panelSearch.add(new JLabel("Student Name: "));
       mSearchText = new JTextField(25);
       panelSearch.add(mSearchText);

       mSearchButton = new JButton("Search");
       mSearchButton.addActionListener(this);
       panelSearch.add(mSearchButton);

       // PSEUDOCODE:
       // Create a JPanel named panelHomework which uses the FlowLayout
       // Add a JLabel "Homework: " to the panel
       // Create mHomeworkText which is an array of JTextFields, one for each homework assignment
       // For i = 0 to the number of homework assignments Do
       //     Create a textfield mHomeworkText[i] displaying 5 cols
       //     Add mHomeworkText[i] to the panel
       // End For
       // Note: DO NOT HARDCODE THE NUMBER OF HOMEWORK ASSIGNMENTS

       JPanel panelHomework = new JPanel(new FlowLayout());
       panelHomework.add(new JLabel("Homework: "));
       mHomeworkText = new JTextField[Main.NUM_HOMEWORKS];

       for (int i = 0; i < Main.NUM_HOMEWORKS; i++) {			
           mHomeworkText[i] = new JTextField(5);
           panelHomework.add(mHomeworkText[i]);

       }

       // Create the exam panel which contains the "Exam: " label and the two exam text fields.
       // The pseudocode is omitted because this code is very similar to the code that creates the
       // panelHomework panel above.
       // Note: DO NOT HARDCODE THE NUMBER OF EXAMS


       JPanel panelExam = new JPanel(new FlowLayout());						

       panelExam.add(new JLabel("Exam: "));

       mExamText = new JTextField[3];				//switched from 2 to 3 columns.

       for (int k = 0; k < 3; k++) {										
           mExamText[k] = new JTextField(5);
           panelExam.add(mExamText[k]);

       }
       // PSEUDOCODE:
       // Create a JPanel named panelButtons using FlowLayout
       // Create the Clear button mClearButton labeled "Clear"
       // Make this View the action listener for mClearButton
       // Add the  Clear button to the panel
       // Repeat the three above statements for the Save button
       // Repeat the three above statements for the Exit button

       //Create an object for JPanel class

       JPanel panelButtons = new JPanel(new FlowLayout());
       
       mClearButton = new JButton("Clear");
       mClearButton.addActionListener(this);     
       panelButtons.add(mClearButton);
       
       mSaveButton = new JButton("Save");
       mSaveButton.addActionListener(this);
       panelButtons.add(mSaveButton);
       
       mExitButton = new JButton("Exit");
       mExitButton.addActionListener(this);
       panelButtons.add(mExitButton); 

       // PSEUDOCODE:
       // Create a JPanel named panelMain using a vertical BoxLayout
       // Add panelSearch to panelMain.
       // Add panelHomework to panelMain
       // Add panelExam to panelMain
       // Add panelButtons to panelMain

       //Create an object for JPanel class

       JPanel panelMain = new JPanel();

       panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
       panelMain.add(panelSearch);
       panelMain.add(panelHomework);
       panelMain.add(panelExam);
       panelMain.add(panelButtons);

       // Initialize the remainder of the frame, add the main panel to the
       // frame,
       // and make the frame visible.

       // Set the title of the View to whatever you want by calling setTitle()
       setVisible(true);
       setTitle("Gradebookulator");
       
       // Set the size of the View to FRAME_WIDTH x FRAME_HEIGHT
       setSize(FRAME_WIDTH, FRAME_HEIGHT);
       
       // Make the View non-resizable
       setResizable(false);
       
       // Set the default close operation to JFrame.DO_NOTHING_ON_CLOSE. This disables the X close
       // button in the title bar of the View so now the only way to exit the program is by click-
       // ing the Exit button. This ensures that Main.exit() will be called so it will write the
       // student records back out to the gradebook database.
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
       // Add panelMain to the View.
       add(panelMain);
       
       // Now display the View by calling setVisible().
       setVisible(true);
   }

   //Implementation of actionPerformed function

   @Override
   public void actionPerformed(ActionEvent pEvent) {

       if (pEvent.getActionCommand().equalsIgnoreCase("Exit")) {						//Check if exit is called
           Main.exit();

       } else if (pEvent.getActionCommand().equalsIgnoreCase("Search"))

       {

           mStudent = Main.search(mSearchText.getText());

           if (mStudent == null) {

               for (int k = 0; k < mHomeworkText.length; k++) {					
                   mHomeworkText[k].setText("");

               }

               int i = 0;

               while(i<mExamText.length){										
                   mExamText[i].setText("");
                  i++;

               }

               JOptionPane.showMessageDialog(this, "No Record found", "Search Result", JOptionPane.WARNING_MESSAGE);

           } else {

               ArrayList<Integer> homeWorkList = mStudent.getHomeworkList();

               if (homeWorkList != null && homeWorkList.size() == 4) {
            	   
                   for (int i = 0; i < homeWorkList.size(); i++) {				
                       mHomeworkText[i].setText(String.valueOf(homeWorkList.get(i)));

                   }
               }

               ArrayList<Integer> examList = mStudent.getExamList();

               if (examList != null && examList.size() == 2) {					

                   for (int i = 0; i < examList.size(); i++) {
                       mExamText[i].setText(String.valueOf(examList.get(i)));

                   }
               }
           }

       } else if (pEvent.getActionCommand().equalsIgnoreCase("Save")) {

           if (mStudent == null) {

               JOptionPane.showMessageDialog(this, "No Record to save", "Save Result", JOptionPane.WARNING_MESSAGE);

           } else {

               for (int k = 0; k < mHomeworkText.length; k++) {			

                   if (mHomeworkText[k].getText() != null) {
                       mStudent.getHomeworkList().set(k, Integer.parseInt(mHomeworkText[k].getText()));

                   }
               }

               for (int j = 0; j < mExamText.length; j++) {				

                   if (mExamText[j].getText() != null) {
                       mStudent.getExamList().set(j, Integer.parseInt(mExamText[j].getText()));

                   }
               }
               
               JOptionPane.showMessageDialog(this, "Record saved successfully", "Save Result", JOptionPane.INFORMATION_MESSAGE);

           }

       } else if (pEvent.getActionCommand().equalsIgnoreCase("Clear")) {

           mSearchText.setText("");

           for (int k = 0; k < mHomeworkText.length; k++) {				

               mHomeworkText[k].setText("");

           }

           int i =0;

           while(i < mExamText.length){									

               mExamText[i].setText("");

           i++;

           }
       }
   }
//could_not_open_gradebooktxt_for_writing_E
   public void messageBox(String pMessage) {//Implementation messageBox function

       JOptionPane.showMessageDialog(this, pMessage, "Not supported yet.", JOptionPane.PLAIN_MESSAGE);

   }    

   public Main getMain() {												//Implementation of getmMain function

       return mMain;

   }

   public void setMain(Main mMain) {										//Implementation of setmMain function

       this.mMain = mMain;

   }

}