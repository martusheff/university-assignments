public class Counter {

    private final String name;
    private int count = 0;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }



    public static void main(String[] args) {
        Counter c1 = new Counter("First");
        Counter c2 = c1;
        c1.increment();
        c2.increment();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
