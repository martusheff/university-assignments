public class FixedCapacityStack<Item> {
    private Item[] data;
    private int n = 0;

    public FixedCapacityStack(int cap) {
        data = (Item[]) new Object[cap];
    }


    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        data[n++] = item;
    }

    public Item pop() {
        return data[--n];
    }

    public static void main(String[] args) {
        FixedCapacityStack st = new FixedCapacityStack<Integer>(5);
        st.push(7);
        System.out.println(st.pop());

    }
}
