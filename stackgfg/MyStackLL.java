package stackgfg;

// Node class to represent each element in the stack
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MyStackLL {
    Node head; // Top of the stack
    int sz;    // Size of the stack

    // Constructor to initialize the stack
    public MyStackLL() {
        this.head = null;
        this.sz = 0;
    }

    // Check if the stack is empty
    boolean isEmpty() {
        return head == null;
    }

    // Push method to add an element to the stack
    Node push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        sz++;
        return head;
    }

    // Pop method to remove the top element from the stack
    int pop() {
        if (isEmpty()) {
            System.out.println("Underflow: Stack is empty, cannot pop");
            return -1; // Return a sentinel value
        }

        int data = head.data;
        head = head.next;
        sz--;
        return data;
    }

    // Peek method to view the top element without removing it
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");
            return -1; // Return a sentinel value
        }

        return head.data;
    }

    // Method to get the size of the stack
    int size() {
        return sz;
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        MyStackLL stack = new MyStackLL();

        System.out.println("Is stack empty? " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after popping: " + stack.size());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element (underflow case): " + stack.pop());
    }
}
