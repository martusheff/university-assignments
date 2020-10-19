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
    public static void main(String[] pArgs) {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader;

        System.out.println("Enter filename: ");
        String filename = sc.nextLine();
        ArrayList<String> contents = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                contents.add(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: file not found.");
            e.printStackTrace();
        }

        int i = 0;
        try{
            FileWriter writer = new FileWriter(filename+".txt");
            for(String line:contents){
                writer.write(lineNum(i) + " " + line);
            }
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }




    }
    public static String lineNum(int i){
        DecimalFormat df = new DecimalFormat("000");
        String num = "[" + df.format(i) + "]";
        return num;
    }


}