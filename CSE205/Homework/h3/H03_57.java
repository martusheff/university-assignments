// CLASS: H03_57 (Source Code File: H03_57.java)
// AUTHOR: Brennon Francis, bqfranci, bqfranci@asu.edu
// AUTHOR: Andronick Martusheff, aamartus, aamartus@asu.edu


import java.util.*;

public class H03_57 {
    
       // function call
       public static int recTernarySearch(ArrayList<Integer> pList, Integer value)
       {
           return recTernarySearch(pList, value, 0, pList.size() - 1);
       }

    

       // rec function
       public static int recTernarySearch(ArrayList<Integer> pList, Integer pKey, Integer low, Integer high) {
           if(low > high)
           return -1;
         
               int range = high - low;
               int oneThirdIdx = (int)Math.round(low + range / 3.0);
               int twoThirdIdx = (int)Math.round(low + range / 1.3333333333333333);

               if (pKey.equals(pList.get(oneThirdIdx))) {
                   return oneThirdIdx;}
               else if (pKey.equals(pList.get(twoThirdIdx))) {
                   return twoThirdIdx;
                 
               }
               else if (pKey < (Integer)pList.get(oneThirdIdx)) {
                    high = oneThirdIdx - 1;
                    return recTernarySearch (pList, pKey, low, high);
                 
               }
               else if (pKey > (Integer)pList.get(twoThirdIdx)) {
                    low = twoThirdIdx + 1;
                    return recTernarySearch (pList, pKey, low, high);
                                    
               }
               else { 
                    low = oneThirdIdx + 1;
                    high = twoThirdIdx - 1;
                    return recTernarySearch (pList, pKey, oneThirdIdx,twoThirdIdx);
               }
}
}

