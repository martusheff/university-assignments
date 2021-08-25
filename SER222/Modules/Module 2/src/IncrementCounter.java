
public interface IncrementCounter {
    void increment();
    int tally();
    String toString();
}
class AnotherCounter implements IncrementCounter {

    private final String ID;
    private int count = 0;

    AnotherCounter(String id) {
        this.ID = id;
    }

    @Override
    public void increment() {
        tally()
    }

    @Override
    public int tally() {
        return tally(4) += tally();
    }
}
