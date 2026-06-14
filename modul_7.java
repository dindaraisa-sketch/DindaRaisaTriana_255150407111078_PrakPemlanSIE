import java.util.LinkedList;
import java.util.Scanner;

public class Antrian {

    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Menu Antrian Pelanggan:");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1-4): ");

            try {

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Masukan Nama Pelanggan: ");
                        String name = sc.nextLine();

                        if (name.equalsIgnoreCase("Budi"))
                            queue.addFirst(name);
                        else
                            queue.addLast(name);

                        System.out.println(name + " ditambahkan ke antrian.");
                        break;

                    case 2:

                        if (queue.isEmpty())
                            System.out.println("Antrian kosong.");
                        else {

                            String nama = queue.poll();

                            System.out.println("Melayani pelanggan : " + nama);
                        }

                        break;

                    case 3:

                        System.out.println("Antrian Saat Ini: " + queue);
                        break;

                    case 4:

                        System.out.println("Keluar.");
                        sc.close();
                        return;

                    default:

                        throw new Exception("Invalid input.");
                }

            } catch (Exception e) {

                System.out.println("Invalid input.");
                sc.next();
            }
        }
    }
}

public class CustomQueue {

    private Node head, tail;
    private int size = 0;

    public void enqueue(int x) {

        Node n = new Node(x);

        if (tail != null)
            tail.next = n;

        tail = n;

        if (head == null)
            head = tail;

        size++;
    }

    public int dequeue() {

        if (head == null)
            throw new RuntimeException("Queue is empty.");

        int val = head.data;

        head = head.next;

        if (head == null)
            tail = null;

        size--;

        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {

        Node current = head;

        System.out.print("Isi Queue: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        CustomQueue queue = new CustomQueue();

        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);

        queue.print();
    }
}

public class CustomStack {

    Node top;
    int size = 0;

    public void push(int x) {

        Node n = new Node(x);

        n.next = top;
        top = n;

        size++;
    }

    public int pop() {

        if (top == null)
            throw new RuntimeException("Stack is empty.");

        int val = top.data;

        top = top.next;

        size--;

        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();
        CustomStack temp = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        temp.push(stack.pop()); // 4
        temp.push(stack.pop()); // 3
        temp.push(stack.pop()); // 2

        stack.push(5);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        System.out.print("Isi Stack: ");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class Node {
    int data;
    Node next;
    Node(int data) { 
        this.data = data; 
    }
}

import java.util.Scanner;
import java.util.Stack;

public class UndoRedo {

    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    public void action(String command) {

        System.out.println("Action: " + command);

        undoStack.push(command);
        redoStack.clear();

        print();
    }

    public void undo() {

        if (undoStack.isEmpty())
            System.out.println("Nothing to undo.");
        else {
            String command = undoStack.pop();
            redoStack.push(command);
        }

        print();
    }

    public void redo() {

        if (redoStack.isEmpty())
            System.out.println("Nothing to redo.");
        else {
            String command = redoStack.pop();
            undoStack.push(command);
        }

        print();
    }

    public void print() {

        System.out.print("Stack Undo: ");
        for (String s : undoStack)
            System.out.print(s + " ");

        System.out.println();

        System.out.print("Stack Redo: ");
        for (String s : redoStack)
            System.out.print(s + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        UndoRedo app = new UndoRedo();
        Scanner scanner = new Scanner(System.in);

        String command;

        while (true) {

            System.out.println("---------------------------------");
            System.out.println("Ketikkan teks sebagai command.");
            System.out.println("Ketik U untuk melakukan Undo");
            System.out.println("Ketik R untuk melakukan Redo");
            System.out.println("Ketik X untuk mengakhiri program.");
            System.out.print("Command: ");

            command = scanner.nextLine();

            if (command.equalsIgnoreCase("x"))
                break;

            if (command.equalsIgnoreCase("u")) {
                app.undo();
            } else if (command.equalsIgnoreCase("r")) {
                app.redo();
            } else {
                app.action(command);
            }
        }

        scanner.close();
        System.out.println("Program selesai.");
    }
}
