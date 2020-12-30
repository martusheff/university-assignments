// CLASS: H03_41 (Source Code File: H03_41.java)
// AUTHOR: Brennon Francis, bqfranci, bqfranci@asu.edu
// AUTHOR: Andronick Martusheff, aamartus, aamartus@asu.edu

public class H03_41 {
    
    private static int recLinearSearch(ArrayList<String> list, String string, int i, int j) {
        for (i = 0; i <= j; i++) {
            if (list.get(i) == string) {
                return i;
            }
        }
        return -1; 
    }
}
