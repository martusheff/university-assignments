//***************************************************************
// CLASS: H1_43
//***************************************************************

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class H1_43 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BufferedReader reader;
        int i = 0;

        System.out.print("Enter sourcecode filename: ");
        String filename = sc.nextLine();
        ArrayList<String> contents = new ArrayList<>(); // list for lines

        try {
            reader = new BufferedReader(new FileReader(filename)); // creating reader
            String line = reader.readLine(); // reads line
            while (line != null) { // while there is a line to be read perform...
                contents.add(line); // add line to array list
                line = reader.readLine(); // read another line
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: file not found.");
            e.printStackTrace();
        }

        try{
            FileWriter writer = new FileWriter(filename+".txt.txt");
            for(String line:contents){ // iterates through ArrayList of lines from original file.
                writer.write(lineNum(i) + " " + line + System.lineSeparator()); // writes to file
                i++; // updated line position for lineNum
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        System.out.println("Your source code was successfully written to " + filename + ".txt"); // informs user
    }

    public static String lineNum(int i){ // Method for line number on side of .txt file.
        DecimalFormat df = new DecimalFormat("000");
        String num = "[" + df.format(i) + "]";
        return num;
    }
}