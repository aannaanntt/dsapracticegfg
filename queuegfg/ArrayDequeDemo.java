package queuegfg;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayDequeDemo {
	
	
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		//Queue<Integer> qLL = new LinkedList<Integer>();
		q.offer(4);
		q.offer(3);
		q.offer(2);
		q.poll();
		System.out.println(q.size());
		System.out.println(q.isEmpty());
	}
}
