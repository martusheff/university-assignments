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

    static int decrement(int n, int counter) {

        if (n == 337) {
            System.out.println("Got to number " + n + " after " + counter + " iterations.");
            return 1;
        }

        return decrement(n - 1, counter + 1);
    }


    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(sumToZero(3));
        System.out.println(fibonnaci(10));

        decrement(828, 0);

    }
}
