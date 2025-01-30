package stackgfg;

import java.util.Stack;

//just add 2 * x - min while adding
public class StackWithGetMinNegative {

	Stack<Integer> s;
	int min;

	StackWithGetMinNegative() {
		s = new Stack<>();
	}

	void push(int x) {

		if (s.isEmpty()) {
			min = x;
			s.add(x);
		} else if (x <= min) {
			s.add(2 * x - min);
			min = x;
		} else {
			s.add(x);
		}
	}

	int pop() {

		int t = s.peek();
		s.pop();
		if (t <= min) {
			int res = min;
			min = 2 * min - t;
			return res;
		} else {
			return t;
		}
	}

	int peek() {
		int t = s.peek();
		return ((t <= min) ? min : t);
	}

	int getMin() {
		return min;
	}

	public static void main(String[] args) {
		StackWithGetMinNegative s = new StackWithGetMinNegative();
		;
		s.push(4);
		s.push(5);
		s.push(8);
		s.push(1);
		s.pop();

		System.out.print(" Minimum Element from Stack: " + s.getMin());

	}
}
