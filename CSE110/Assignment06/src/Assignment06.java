// CSE 110     : CSE110 - Session A
// Assignment  : Assignment06.java
// Author      : Andronick Martusheff - 1219284898
// Description : 10 Array Methods

public class Assignment06 {
    public static void main(String[] args) {
        int[] myArray = {1, 22, 333, 400, 5005, 9};

        printArray(myArray, ", ");
        printArray(myArray, " - ");
        getFirst(myArray);
        getLast(myArray);
        getAllButFirst(myArray);
        getIndexOfMin(myArray);
        getIndexOfMax(myArray);
        swapByIndex(myArray, 1, 4);
        removeAtIndex(myArray, 3);
        insertAtIndex(myArray, 2, 777);
        isSorted(myArray);


        // Below is a call to all 10 methods (marked '// #')
        /*
        printArray(myArray, ", "); // 1
        printArray(myArray, " - "); // 1
        System.out.println(getFirst(myArray)); // 2
        System.out.println(getLast(myArray)); // 3
        printArray(getAllButFirst(myArray),", "); // 4
        System.out.println(getIndexOfMin(myArray)); // 5
        System.out.println(getIndexOfMax(myArray)); // 6
        printArray(swapByIndex(myArray,1,4), ", "); // 7
        printArray(removeAtIndex(myArray,3),", "); // 8
        printArray(insertAtIndex(myArray, 2, 777), ", "); // 9
        System.out.println(isSorted(myArray)); // 10
        */


    }

    public static void printArray(int[] myArray, String space) { // 1
        String vals = "";
        for (int i = 0; i < myArray.length; i++) {
            if(i < myArray.length-1)
                vals += (String.valueOf(myArray[i]) + space);
            else
                vals += String.valueOf(myArray[i]);
        }
        System.out.println(vals);
    }

    public static int getFirst(int[] myArray) { // 2
        return myArray[0];
    }

    public static int getLast(int[] myArray) { // 3
        return myArray[myArray.length - 1];
    }

    public static int[] getAllButFirst(int[] myArray) { // 4
        int[] newArray = new int[myArray.length - 1];
        for (int i = 0; i < myArray.length - 1; i++) {
            newArray[i] = myArray[i + 1];
        }
        return newArray;
    }

    public static int getIndexOfMin(int[] myArray) { // 5
        int index = 0;
        int min = myArray[index];
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] <= min) {
                min = myArray[i];
                index = i;
            }
        }
        return index;
    }

    public static int getIndexOfMax(int[] myArray) { // 6
        int index = myArray.length - 1;
        int max = myArray[index];
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] >= max) {
                max = myArray[i];
                index = i;
            }
        }
        return index;
    }

    public static int[] swapByIndex(int[] myArray, int first, int second) { // 7
        int temp = myArray[first];
        myArray[first] = myArray[second];
        myArray[second] = temp;
        return myArray;
    }

    public static int[] removeAtIndex(int[] myArray, int index) { // 8
        int[] newArray = new int[myArray.length - 1];
        for (int i = 0, j = 0; i < myArray.length; i++) {
            if (i == index) {
                continue;
            } else {
                newArray[j++] = myArray[i];
            }
        }
        return newArray;
    }

    public static int[] insertAtIndex(int[] myArray, int index, int val) { // 9
        int[] newArray = new int[myArray.length + 1];
        for(int i = 0; i < myArray.length+1;i++) {
            if(i < index-1)
                newArray[i] = myArray[i];
            else if(i == index - 1)
                newArray[index] = val;
            else
                newArray[i] = myArray[i-1];

        }

        return newArray;
    }

    public static boolean isSorted(int[] myArray) { // 10
        boolean sorted;
        for(int i = 0; i < myArray.length - 1; i++){
            if(myArray[i] > myArray[i+1])
                return false;
            }
        return true;
        }


}

