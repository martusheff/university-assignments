import java.util.Scanner;
import java.util.Vector;

public class FixedCapacityStringStack {

    private String[] data;
    private int n = 0;

    public FixedCapacityStringStack(int cap) {
        data = new String[cap];
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String item) {
        data[n++] = item;
    }

    public String pop() {

        return data[--n];
    }

    public static void uiStackInteractor() {
        Scanner s = new Scanner(System.in);
        boolean inUse = true;
        System.out.println("Enter 'q' at any time to quit.");
        System.out.println("Let's start by creating a stack.\nWhat's the size of your fixed stack?");
        int stackSize = s.nextInt();
        FixedCapacityStringStack stack = new FixedCapacityStringStack(stackSize);
        System.out.println("Stack of size '" + stackSize + "' created.");
        System.out.println("Push/Pop from stack -- ex. 'Push {entry}' or 'Pop'.");

        while (inUse) {
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();


            if(response.equals("q") ){
                inUse = false;
                return;
            }

            if(response.equals("Pop")) {
                System.out.println("Your popped string is: '" + stack.pop() + "'.");
            } else {
                String valToPush = handleInput(response);
                stack.push(valToPush);
                System.out.println("Successfully pushed '" + valToPush + "' to stack." );
            }
            response = "";



        }

    }

    public static String handleInput(String input) {
        String[] parts = input.split(" ");

        return parts[1];


    }

    public static void main(String[] args) {



        uiStackInteractor();
        System.out.println("All done.");

    }
}
