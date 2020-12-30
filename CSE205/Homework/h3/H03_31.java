// CLASS: H03_31 (Source Code File: H03_31.java)
// AUTHOR: Brennon Francis, bqfranci, bqfranci@asu.edu
// AUTHOR: Andronick Martusheff, aamartus, aamartus@asu.edu

public class H03_31 {
    public int sum1toN (int n){
        if (n == 1) {
            return 1;
        } else {
            return n + sum1toN(n - 1);
        }
    }
}