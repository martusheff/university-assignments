
import java.util.ArrayList;

public class quiz {

    public static void main(String args[]) {
        //
        int[][] a = {
                { 47, 56, 77},
                { 56, 77, 47},
                { 77, 47, 56}
        };
        System.out.println(a[1][2]);
        spacer();
        //
        int[] A = new int[4];
        A[0] = 23;
        A[1] = 45;
        A[2] = 27;
        A[3] = 36;
        System.out.println(A[1]);
        //
        spacer();
        int[] B = {23, 45, 27, 36};
        System.out.println(B[2]);
        //
        spacer();
        int size = 4;
        int[] C = new int[size];
        C[0] = 23;
        C[1] = 45;
        C[2] = 27;
        C[3] = 36;
        System.out.println(C[3]);
        //
        spacer();
        ArrayList <String> lastNames = new ArrayList<>();
        lastNames.add("Simpson");
        lastNames.add("Griffin");
        lastNames.add("Flintstone");

        lastNames.set(0, "Jetson");

        for(String name:lastNames){
            System.out.println(name);
        }

        //
        spacer();
        String a1 = "aaaa";
        int a2 = 2;
        double a3 = 3.0;

        System.out.println(a1 + "-" + a2 + "-" + a3);



    }

    public static void spacer(){
        System.out.println("*******************************");
    }
}
