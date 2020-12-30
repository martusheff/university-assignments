// CLASS: H03_32 (Source Code File: H03_32.java)
// AUTHOR: Brennon Francis, bqfranci, bqfranci@asu.edu
// AUTHOR: Andronick Martusheff, aamartus, aamartus@asu.edu

public class H03_32 {
    public double power(double x, int n){
        if(n == 0){
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }
}
