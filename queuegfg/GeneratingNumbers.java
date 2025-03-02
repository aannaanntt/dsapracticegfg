package queuegfg;

import java.util.ArrayDeque;
import java.util.Queue;

public class GeneratingNumbers {

	public static void main(String[] args) {
		Queue<String> q = new ArrayDeque<String>();
		q.offer("5");
		q.offer("6");
		int n = 4;
		for (int i = 0; i < n; i++) {
			String str = q.poll();
			System.out.println(str);
			q.offer(str + "5");
			q.offer(str + "6");

		}
	}

}
