/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 *
 * @author (your name), Acuna
 * @version (version)
 */
import java.util.NoSuchElementException;



//TODO: implement.
public class MartusheffDeque<Item> implements Deque<Item> {

    int size = 0;
    /**
     * Program entry point for deque.
     */

    class Node<Item> {
        private Item item;
        Node next;
        Node prev;



        public Node(Item item) {
            this.item = item;
        }


    }

    Node head, tail = null;

    public static void main(String[] args) {
        MartusheffDeque<Integer> deque = new MartusheffDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());


        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }

    @Override
    public void enqueueFront(Item element) {
        Node newNode = new Node(element);


        if(head == null) {
            head = newNode;
            head.prev = null;
            head.next = null;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            head.prev = null;
        }
        size++;
    }

    @Override
    public void enqueueBack(Item element) {
        Node newNode = new Node(element);

        if(head == null && tail == null) {
            head = newNode;
            head.prev = null;
            head.next = null;
        } else if(head.next == null) {
            head.next = newNode;
            tail = newNode;
            tail.prev = head;
            tail.next = null;
        } else
            {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                tail.next = null;
            }

        size++;
    }

    @Override
    public String toString() {
        Node current = tail;
        String contents = "";

        while(current != null) {
            contents += current.item + " ";
            current = current.prev;


        }

        return contents;
    }

    @Override
    public Item dequeueFront() throws NoSuchElementException {
        Item data = (Item) head.item;
        head = head.next;
        head.prev = null;
        size--;
        return data;
    }

    @Override
    public Item dequeueBack() throws NoSuchElementException {
        Item data = (Item) tail.item;
        tail = tail.prev;
        tail.next = null;
        size--;
        return data;
    }

    @Override
    public Item first() throws NoSuchElementException {
        return (Item) head.item;
    }

    @Override
    public Item last() throws NoSuchElementException {
        return (Item) tail.item;
    }

    @Override
    public boolean isEmpty() {
        return(size == 0);
    }

    public void printNodes() {
        Node current = head;
        if(head == null) {
            System.out.println("Double linked list is empty.");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            System.out.println(current.item + " ");
            current = current.next;
        }
    }


    @Override
    public int size() {
        return size;
    }
}