package stackgfg;

import java.util.Stack;

public class InfixToPostfix {
	
	public static String getInfixToPostFixRec(String str, StringBuilder sb , int idx, Stack<Character> st) {
		if(idx == str.length()) {
			while(!st.isEmpty()) {
				sb.append(st.pop()).append(" ");
			}
			
			return sb.toString();
		}
		
		// same logic neeche wala aaega
		
		return getInfixToPostFixRec(str,sb,idx+1,st);
	}
	
    public static String getInfixToPostfix(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If operand, add to output
            if (Character.isLetter(ch)) {
                postfix.append(ch).append(" ");
            } 
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // If ')', pop and append until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                }
            } 
            // If operator, pop higher precedence operators and then push
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators in stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    // Operator precedence method
    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return 0;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        String infix = "a+(b*c)";
        System.out.println("Postfix: " + getInfixToPostfix(infix));
    }
}
