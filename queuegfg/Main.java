package queuegfg;
import java.util.ArrayDeque;
import java.util.Queue;

class StackUsingQueueRecursion {
    Queue<Integer> q;

    public StackUsingQueueRecursion() {
        this.q = new ArrayDeque<>();
    }

    void push(int x) {
        q.offer(x); // Simply enqueue the new element
    }

    int pop() {
        if (q.isEmpty()) return -1;

        // Remove front element
        int front = q.poll();

        // If queue is empty after removing, return the last element
        if (q.isEmpty()) {
            return front;
        }

        // Recursive call to reach the last inserted element
        int last = pop();

        // Restore the queue order
        q.offer(front);

        return last;
    }

    int top() {
        if (q.isEmpty()) return -1;

        int front = q.poll();

        if (q.isEmpty()) {
            q.offer(front); // Restore the last element
            return front;
        }

        int last = top();
        q.offer(front); // Restore queue order

        return last;
    }

    boolean isEmpty() {
        return q.isEmpty();
    }

    int size() {
        return q.size();
    }
}

// Example Usage
public class Main {
    public static void main(String[] args) {
        StackUsingQueueRecursion stack = new StackUsingQueueRecursion();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
    }
}
