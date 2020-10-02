import java.text.DecimalFormat;

/*-------------------------------------------------------------
//AUTHOR: Andronick Martusheff
//FILENAME: Student.java
//SPECIFICATION: File for the Student Class
//FOR: CSE110 Lab 7
//-----------------------------------------------------------*/
public class Student {
    String firstName, lastName, fullName, asuID;
    double grade;
    int accessed, updates;


    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.fullName = firstName + " " + lastName;
        this.grade = -1;
    }


    public Student(String firstName, String lastName, double grade) {
        super();
        this.fullName = firstName;
        this.asuID = lastName;
        this.grade = grade;

    }



    public String getFullname() {
        accessed++;
        return fullName;
    }
    public void setName(String fullName){
        updates++;
        this.fullName = fullName;
    }

    public String getAsuID() {
        accessed++;
        return asuID;
    }

    public void setId(String asuID) {
        updates++;
        this.asuID = asuID;
    }


    public double getGrade() {
        accessed++;
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
        updates++;
    }


    public String toString() {
        return "Name: " + fullName + ", ASU ID: " + asuID + ", Grade: " + grade;
    }

    public boolean equals(Student other){
        if(this.asuID == other.asuID){
            return true;
        } else if(this.fullName.toLowerCase().equals(other.fullName.toLowerCase())){
            return true;
        } else {
            return false;
        }

    }
    public int getNumOfUpdates() {
        accessed++;
        return updates;
    }
    public int getNumOfAccessed() {
        accessed++;
        return accessed;
    }
}


