package queuegfg;

public class QueueDemo {
	//take 2 variables one for keeping track of tatal queu filled and other will be the capacity
	int size; int cap;
	int[] arr; // to store the queue elements
	
	public QueueDemo(int cap) {
		this.arr = new int[cap];
		this.cap=cap;
		this.size=0;
	}
	
	boolean isFull() {
		return size == cap;
	}
	boolean isEmpty() {
		return size ==0;
	}
	
	//aage lgega
	void enqueue(int x) {
		if(isFull()) return;
		arr[size] =x;
		size++;
		
	}
	// deque is fromk back and we have array to just shift every element one place
	 void dequeue() {
		 if(isEmpty()) return;
		 for(int i=0;i<size -1;i++) {
			 arr[i] = arr[i+1];
		 }
		 size--;
	 }
	 
	 int getFront() {
		 if(isEmpty()) return -1;
		 return arr[0];
	 }
	 int getLast() {
		 if(isEmpty()) return -1;
		 return arr[size -1];
	 }
	
	
	public static void main(String[] args) {
		QueueDemo qd = new QueueDemo(4);
		qd.enqueue(4);

	}

}
