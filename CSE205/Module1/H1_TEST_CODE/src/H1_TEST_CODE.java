
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class H1_TEST_CODE {


    public static void main(String args[]) {

        // Code that lead to the solution for 3.2.
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 0));

        // Call for 3.3
        String str1 = " caaaaaaaaaaaaaaaaaaa", str2 = "tZZZZZZZZZZZZZZZZZZZZZZZZ";

        System.out.println(str1.compareToIgnoreCase(str2));;



        for(int i = 1; i < 10; i++) {
            list.set(i, list.get(i) + list.get(i-1));
        }

        ArrayList<String> cities = new ArrayList<>(Arrays.asList("london", "new York", "yorkshire"));


        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,5,6,7));
        arrayListRemove(numbers, 7);

        insertName(cities, "portland");
        insertName(cities, "anaheim");
        insertName(cities, "st. louis");
        insertName(cities, "ontario");
        insertName(cities, "ontarin");


        System.out.println(cities);







    }
    // 3.3 Code for Word Processor submission.
    public static int getNumNegative(ArrayList<Integer> list) {
        int numNegative = 0;
        for(Integer num : list) {

            if(num < 0)
                numNegative++;
        }
        return numNegative;
    }

    // 3.6 Code for String Insertion submission.
    public static void insertName(ArrayList<String> pList, String pName){
        for(int i = 0; i < pList.size(); i++) {
            if ((pName.compareToIgnoreCase(pList.get(i))) <= 0) {
                pList.add(i, pName);
                break;
            } else if(i == pList.size() - 1) {
                pList.add(pName);
                break;
            }
        }
    }


    // 3.7 Code for Int removal from pList
    public static void arrayListRemove(ArrayList<Integer> pList, int pValue) {
        pList.removeIf(value -> value == pValue);
    }




}

/*
    public static void insertName(ArrayList<String> pList, String pName){
        for(int i = 0; i < pList.size(); i++) {
            if ((pName.compareToIgnoreCase(pList.get(i))) <= 0) {
                pList.add(i, pName);
                break;
            } else if ((pName.compareToIgnoreCase(pList.get(i))) > 0) {
                if (i == pList.size() - 1) {
                    pList.add(pName);
                    break;
                }
            }

        }
    }
*/

