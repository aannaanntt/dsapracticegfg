package queuegfg;

//this will be a circular queue which is more eff we dont need to iterate over it we can
// do in o(1)
public class QueueDemoEff {
	int[] arr;
	//we will take 2 pointers
	int front;
	int size;
	int rear;
	int cap;
	public QueueDemoEff(int cap) {
		this.cap=cap;
		this.size=0;
		this.arr = new int[cap];
		this.front =0;
		this.rear = -1;
	}
	
	
	boolean isFull() {
		return size == cap;
	}
	boolean isEmpty() {
		return size ==0;
	}
	//enque peeche se lgana h
	void enqueue(int x) {
		if(isFull()) return;
		rear = (rear + 1 ) % cap;
		arr[rear] = x;
		size ++;
		
	}
	
	void dequeue() {
		if(isEmpty()) return;
		front = (front + 1 )% cap;
		size --;
	}
	
	int getFront() {
		if(isEmpty()) return -1;
		return arr[front];
	}
	int getLast() {
		if(isEmpty()) return -1;
		return arr[rear];
	}
	
	void disPlay() {
		for(int i=0;i< size ;i++) {
			System.out.println(arr[(front + i) % cap] );
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
	}

}
