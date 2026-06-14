public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init() {
        head = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // 8g - insert before value
    void insertBeforeValue(Object key, Node data) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(key)) {

                if (current == head) {
                    addFirst(data);
                    return;
                }

                Node prevNode = current.prev;

                prevNode.next = data;
                data.prev = prevNode;

                data.next = current;
                current.prev = data;

                size++;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node("A");
        Node nodeC = new Node("C");

        list.addLast(nodeA);
        list.addLast(nodeC);

        System.out.println("Sebelum insert:");
        list.print();

        Node nodeB = new Node("B");
        list.insertBeforeValue("C", nodeB);

        System.out.println("\nSetelah insert before C:");
        list.print();
    }
}

public class Node {
    Object data;
    Node next, prev;

    Node() {
    }

    Node(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        System.out.println("node: " + nodeA);
        System.out.println("data: " + nodeA.data);
        System.out.println("next: " + nodeA.next);
        System.out.println("prev: " + nodeA.prev);
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        nodeA.next = nodeB;
        nodeA.prev = nodeC;
        System.out.println("next data : " + nodeA.next.data);
        System.out.println("prev data : " + nodeA.prev.data);
    }
}

public class SingleLinkedList {

    Node head, tail;
    int size = 0;

    void init() {
        head = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    Node find(Object data) {

        Node current = head;

        while (current != null) {

            if (current.data.equals(data)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    void addBefore(Object key, Node data) {

        if (isEmpty()) return;

        if (head.data.equals(key)) {
            addFirst(data);
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.equals(key)) {

                data.next = current.next;
                current.next = data;

                size++;
                return;
            }

            current = current.next;
        }
    }

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();

        list.addLast(new Node("A"));
        list.addLast(new Node("C"));
        list.addLast(new Node("D"));

        list.addBefore("C", new Node("B"));

        Node current = list.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
