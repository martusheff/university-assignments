
import java.util.Stack;


interface DogInterface {
    void bark();
    void eat();
}
abstract class Dog {

    String breed;

    public void bark() {
        System.out.println("Woof!");
    }

    public abstract void eat();

}

class Pug extends Dog {
    public void eat() {
        System.out.println("Dog ate!");
    }
}
public class ADT {

    private Stack<Integer> stack = new Stack<Integer>();

    private void pushSquaredToStack(int n) {
       stack.push(n*n);
    }


    public static void main(String[] args) {
        ADT myStack = new ADT();

        myStack.pushSquaredToStack(5);
        System.out.println(myStack.stack.peek());
        myStack.pushSquaredToStack(91);
        myStack.pushSquaredToStack(32);
        myStack.pushSquaredToStack(11);
        myStack.pushSquaredToStack(123);

        int n = myStack.stack.pop();
        System.out.println(n);

        Pug Baxter = new Pug();
        Baxter.bark();
        Baxter.eat();





    }
}
