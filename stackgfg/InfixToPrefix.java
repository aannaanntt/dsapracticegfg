package stackgfg;

import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {
		String str = "( a+ ( b * c))";
		String output = getInfixAToPrefix(str);
		System.out.println(output);
	}

	private static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}

	private static String getInfixAToPrefix(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder prefix = new StringBuilder();

		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				prefix.append(ch);
			} else if (ch == ')') {
				stack.push(ch);
			} else if (ch == '(') {
				while (!stack.isEmpty() && stack.peek() != ')') {
					prefix.append(stack.pop()).append(" ");
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)) {
					prefix.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		return prefix.reverse().toString();
	}

}
