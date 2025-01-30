package stackgfg;

import java.util.Stack;

public class PostFixToInfix {

	
	public static void main(String[] args) {
		  String postfix = "abc*+"; // Example: Postfix expression "a b c * +"
	        String infix = getPostfixToInfix(postfix);
	        
	        System.out.println("Infix Expression: " + infix);
	}
	
	 public static String getPostfixToInfixRec(String postfix, Stack<String> stack, int idx) {
	        // Base case: If we have processed all characters, return the final expression
	        if (idx == postfix.length()) {
	            return stack.pop(); 
	        }

	        char ch = postfix.charAt(idx);

	        if (Character.isLetterOrDigit(ch)) { // If operand, push it to stack
	            stack.push(Character.toString(ch));
	        } else { // If operator, pop two operands, create an infix expression, and push back
	            String operand2 = stack.pop();
	            String operand1 = stack.pop();
	            String expression = "(" + operand1 + " " + ch + " " + operand2 + ")";
	            stack.push(expression);
	        }

	        // Recursive call for the next character
	        return getPostfixToInfixRec(postfix, stack, idx + 1);
	    }

	private static String getPostfixToInfix(String postfix) {
		Stack<String> st = new Stack<String>();
		for(int i=0;i<postfix.length();i++) {
			char ch = postfix.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				st.push(Character.toString(ch));
			}else {
				String operand1 = st.pop();
				String operand2 = st.pop();
				String expr = "(" + operand1 +ch + operand2 + ")";
				st.push(expr);
			}
		}
		return st.pop();
	}
}
