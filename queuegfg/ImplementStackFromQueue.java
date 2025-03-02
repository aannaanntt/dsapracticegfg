package queuegfg;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackFromQueue {

	
	Queue<Integer> q;
	
	public ImplementStackFromQueue(int size) {
		this.q = new ArrayDeque<Integer>(size);
		
	}
	
	int top() {
		if(q.isEmpty()) return -1;
 		return q.peek();
	}
	int size() {
		return q.size();
	}
	void push(int x) {
		int n =q.size();
		q.offer(x);
		//rotate the queue to maintain LIFO
		for(int i=0;i<n;i++) {
			q.offer(q.poll());
		}
	}
	
	void pop() {
		if(q.isEmpty()) return;
		q.poll();
	}
}
