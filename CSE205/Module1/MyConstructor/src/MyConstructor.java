public class MyConstructor {
    int x = 5;

    MyConstructor() {
        System.out.print("x" + x);
    }
    MyConstructor(int x) {
        this();
        System.out.print("x" + x);
    }

    public static void main(String[] args){
        MyConstructor mc1 = new MyConstructor(4);
        MyConstructor mc2 = new MyConstructor();

    }

}