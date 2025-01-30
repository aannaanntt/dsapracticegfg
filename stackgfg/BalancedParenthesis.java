package stackgfg;

import java.util.Stack;

public class BalancedParenthesis {
	
	public static void main(String[] args) {
		System.out.println(isBalanced("([])"));   // true
        System.out.println(isBalanced("{[()]}")); // true
        System.out.println(isBalanced("(([])")); // false
        System.out.println(isBalanced(")("));    // f
	}
	
	static boolean isMatching(char a , char b) {
		return (a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b== '}');
	}
	
	   private static boolean isBalancedNaive(String string) {
	        // Keep replacing valid pairs until no change happens
	        while (string.contains("()") || string.contains("[]") || string.contains("{}")) {
	            string = string.replace("()", "")
	                           .replace("[]", "")
	                           .replace("{}", "");
	        }
	        // If the string is empty, it is balanced
	        return string.isEmpty();
	    }

	private static boolean isBalanced(String string) {
		int l=0; int r = string.length()-1;
		Stack<Character> st = new Stack<>();
		while(l<=r) {
			char leftChar = string.charAt(l);
			if(leftChar == '[' || leftChar =='{' || leftChar== '(') {
				st.push(leftChar);
			}
			else if(leftChar == ')' || leftChar==']' || leftChar=='}') {
				if(st.isEmpty()) {
					return false;
				}
				char top = st.pop();
				if(!isMatching(top,leftChar)) {
					return false;
				}
			}
			
			l++;
		}
		return st.isEmpty();
		
	}
}
