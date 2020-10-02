/*-------------------------------------------------------------
//AUTHOR: Andronick Martusheff
//FILENAME: Student.java
//SPECIFICATION: File for the Student Class
//FOR: CSE110 Lab 7
//-----------------------------------------------------------*/
public class Student {
    String firstName, lastName, fullName, asuID;
    double grade;

    public Student(String firstName, String lastName, String asuID, double grade) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.asuID = asuID;
        this.grade = grade;
    }



    public String getFullName() {
        return fullName;
    }


    public String getAsuID() {
        return asuID;
    }


    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public String toString() {
        return "Student: " + fullName + ", ASU ID: " + asuID + ", Grade: " + grade;
    }
}
