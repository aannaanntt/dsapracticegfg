package queuegfg;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;



public class QueueReverse {
	static void reverse(Queue<Integer> q) {
		if(q.isEmpty()) {
			return;
		}
		int ele = q.poll();
		reverse(q);
		q.offer(ele);
	}
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(12);
		q.add(13);
		q.add(56);
		q.add(39);
//		Stack<Integer> st = new Stack<Integer>();
//		//reverse a queue
//		while(q.isEmpty() == false) {
//			st.push(q.poll());
//			
//		}
//		while(!st.isEmpty()) {
//			q.offer(st.pop());
//		}
		reverse(q);
		System.out.println(q);
		
	}

}
