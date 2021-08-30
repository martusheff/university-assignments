import java.util.Arrays;

public class Stack<Item> {
    private Item[] data;
    private int n = 0;

    public Stack() {
        data = (Item[]) new Object[100];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        if(data.length == n)
            resize();
        data[n++] = item;
    }

    public Item pop() {
        return data[--n];
    }

    public void resize() {
        data = Arrays.copyOf(data, data.length*2);
    }
}
