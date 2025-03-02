package queuegfg;

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}


public class QueueDemoLL {
	Node front; Node rear;
	public QueueDemoLL() {
		this.front=null;
		this.rear = null;
	}
	
	//enqueue should happen from rear
	void enqueue(int data) {
		Node temp = new Node(data);
		if(front == null && rear == null) {
			front = rear = temp;
			return;
		}
		
		// mtlb k 
		rear.next = temp;
		rear = rear.next;
		
	}
	
	void deque() {
		if(front == null) return;
		front = front.next;
		if(front == null) rear = null;
	}
}
