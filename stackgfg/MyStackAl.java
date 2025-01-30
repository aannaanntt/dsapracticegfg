package stackgfg;

import java.util.ArrayList;

public class MyStackAl {
	// make an arraylist to store data
	ArrayList<Integer> al = new ArrayList<Integer>();

	void push(int data) {
		al.add(data);
	}

	int pop() {
		int res = al.get(al.size() - 1);
		al.remove(al.size() - 1);
		return res;
	}

	int peek() {
		return al.get(al.size() - 1);
	}

	boolean iEmpty() {
		return al.isEmpty();
	}

	int size() {
		return al.size();
	}

	public static void main(String[] args) {
		MyStackAl ms = new MyStackAl();
		ms.push(56);
		ms.push(78);
		System.out.println(ms.peek());
	}

}
