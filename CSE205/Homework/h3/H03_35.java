// CLASS: H03_35 (Source Code File: H03_35.java)
// AUTHOR: Brennon Francis, bqfranci, bqfranci@asu.edu
// AUTHOR: Andronick Martusheff, aamartus, aamartus@asu.edu

public class H03_35 {
    public String reverse(String s) {
        if(s.length() == 0) {
            return "";
        } else {
            return reverse(s.substring(1, s.length())) + s.charAt(0);
        }
    }
}
