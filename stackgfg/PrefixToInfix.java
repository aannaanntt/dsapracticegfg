package stackgfg;

import java.util.Stack;

public class PrefixToInfix {
	
	
	 public static void main(String[] args) {
	        String prefix = "*+abc";  // Example prefix expression
	        String infix = getPrefixToInfix(prefix);
	        System.out.println("Infix Expression: " + infix);
	    }

	    private static String getPrefixToInfix(String str) {
	        Stack<String> stack = new Stack<>();

	        // Traverse the prefix expression from right to left
	        for (int i = str.length() - 1; i >= 0; i--) {
	            char ch = str.charAt(i);

	            // If the character is an operand, push it onto the stack
	            if (Character.isLetterOrDigit(ch)) {
	                stack.push(String.valueOf(ch));
	            }
	            // If the character is an operator
	            else {
	                // Pop two operands from the stack
	                String operand1 = stack.pop();
	                String operand2 = stack.pop();

	                // Combine them in the form of (operand1 operator operand2) and push back to the stack
	                String infix = "(" + operand1 + ch + operand2 + ")";
	                stack.push(infix);
	            }
	        }

	        // The final item in the stack is the complete infix expression
	        return stack.pop();
	    }

}
