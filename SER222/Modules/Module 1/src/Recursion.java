public class Recursion {
    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n*factorial(n-1);
    }

    static int sumToZero(int n) {
        if (n == 0)
            return n;
        else
            return n+sumToZero(n-1);
    }

    static long fibonnaci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonnaci(n-1) + fibonnaci(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(sumToZero(3));
        System.out.println(fibonnaci(10));
    }
}
