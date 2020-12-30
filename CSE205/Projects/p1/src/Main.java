/*********************************************************************************************************
 * CLASS: CSE205
 *
 * DESCRIPTION
 * Project1 takes in a specified file and writes the runs output to a new formatted file.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Session B 2020
 * Project Number: 1
 *
 * GROUP INFORMATION
 * AUTHOR 1: Andronick Martusheff, aamartus, aamartus@asu.edu
 * AUTHOR 2: Brennon Francis, bqfranci, bqfranci@asu.edu
 ********************************************************************************************************/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Main mainObject = new Main();
        mainObject.run();
    }

    // called in main. checks and calculates runs, writes runs result to file.
    private void run() throws FileNotFoundException {
        ArrayList<Integer> list = null;
        final String UP = "up";
        final String DOWN = "down";

        try {
            list = readFile("p1-in.txt");
        } catch (FileNotFoundException eRead) {
            System.out.println("Oops, could not open 'p1-in.txt' for reading. The program is ending.");
            System.exit(-100);
        }

        ArrayList<Integer> listRunsUpCount = new ArrayList<>();
        ArrayList<Integer> listRunsDnCount = new ArrayList<>();
        ArrayList<Integer> listRunsCount = new ArrayList<>();
        listRunsUpCount = findRuns(list, UP);
        listRunsDnCount = findRuns(list, DOWN);
        listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount);
        try {
            writeOutputFile("p1-runs.txt", listRunsCount);
        } catch (FileNotFoundException eWrite) {
            System.out.println("Oops, could not open 'p1-in.txt' for writing. The program is ending.");
            System.exit(-200);
        }
    }

    // creates array list
    public ArrayList<Integer> arrayListCreate(int pSize, int pInitValue) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < pSize; i++) {
            list.add(pInitValue);
        }
        return list;
    }


    // read specified file, return ArrayList of Integers within file.
    public ArrayList<Integer> readFile(String fileToParse) throws FileNotFoundException {
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        File fileInput = new File(fileToParse);
        Scanner s = new Scanner(fileInput);
        while (s.hasNextInt()) {
            listOfIntegers.add(s.nextInt());
        }
        return listOfIntegers;
    }

    //determines runs count
    public ArrayList<Integer> findRuns(ArrayList<Integer> pList, String pDir) {
        ArrayList<Integer> listRunsCount = arrayListCreate(pList.size(), 0);
        int num;
        int i = 0;
        int j = 0;

        while (i < pList.size() - 1) {
            if (pDir.equals("up") && pList.get(i) <= pList.get(i + 1)) {
                j++;
            } else if (pDir.equals("down") && pList.get(i) >= pList.get(i + 1)) {

                j++;
            } else {
                if (j != 0) {
                    num = listRunsCount.get(j);
                    listRunsCount.set(j, num + 1);
                    j = 0;
                }
            }
            i++;
        }
        if (j != 0) {
            num = listRunsCount.get(j);
            listRunsCount.set(j, num + 1);
            j = 0;
        }
        return listRunsCount;
    }

    // merges ups and downs runs
    public ArrayList<Integer> mergeLists(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount) {
        ArrayList<Integer> listRunsCount = arrayListCreate(pListRunsUpCount.size(), 0);
        for (int i = 0; i < pListRunsUpCount.size() - 1; i++) {
            int sum = pListRunsUpCount.get(i) + pListRunsDnCount.get(i);
            listRunsCount.set(i, sum);
        }
        return listRunsCount;
    }

    // writes file
    public void writeOutputFile(String pFileName, ArrayList<Integer> pListRuns) throws FileNotFoundException {
        File outputFile = new File(pFileName);
        PrintWriter output = new PrintWriter(outputFile);
        int sumPListRuns = 0;
        for (int i = 0; i < pListRuns.size(); i++) {
            sumPListRuns += pListRuns.get(i);
        }
        output.println("runs_total: " + sumPListRuns + "\n");
        for (int j = 1; j < pListRuns.size() - 1; j++) {
            output.println("runs_" + j + ": " + pListRuns.get(j));
        }
        output.close();
    }
}