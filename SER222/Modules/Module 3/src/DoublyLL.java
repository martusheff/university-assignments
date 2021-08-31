class DoublyLL {

    // Node class
    class Node {
        int item;
        Node prev;
        Node next;

        // Constructor for Node
        public Node(int item) {
            this.item = item;
        }
    }

    // Initialize head/tail of Node to 'null'
    Node head, tail = null;

    // Add node to list
    public void addNodeToEnd(int item) {
        Node newNode = new Node(item);

        if(head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void addNodeToStart(int item) {
        Node newNode = new Node(item);

        if(head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            head.prev = null;
        }
    }

    public int popFromStart() {
        int value = head.item;
        head = head.next;
        head.prev = null;
        System.out.println("Popped '" + value + "' from front of list.");
        return value;
    }

    public int popFromEnd() {
        int value = tail.item;
        tail = tail.prev;
        tail.next = null;
        System.out.println("Popped '" + value + "' from back of list.");
        return value;
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


}

class Main {
    public static void main(String[] args) {
        DoublyLL newList = new DoublyLL();

        newList.addNodeToEnd(11);
        newList.addNodeToEnd(12);
        newList.addNodeToStart(10);



        newList.printNodes();
        newList.popFromStart();
        newList.popFromEnd();
        newList.printNodes();

        newList.addNodeToStart(789);
        newList.addNodeToEnd(123);
        newList.addNodeToEnd(456);
        newList.addNodeToStart(789);

        newList.printNodes();
        newList.popFromStart();
        newList.popFromEnd();
        newList.printNodes();

    }
}
