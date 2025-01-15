package stringgfg;

public class StringPalindrome {
	
	
	public static void main(String[] args) {
		String str = "madam";
		
		
		//naiveApproach(str);
		
		isPalindromeEff(str);
	}
	
	
	private static void isPalindromeEff(String str) {
		int n = str.length();
		int i_pointer = 0;
		int j_pointer = str.length() -1 ;
		while(i_pointer<j_pointer) {
			if(str.charAt(i_pointer)== str.charAt(j_pointer)) {
				i_pointer++;
				j_pointer--;
			}else {
				System.out.print("No Palindrome");
			}
		}
		
		System.out.println("Palindrome");
		
	}


	public static void naiveApproach(String str) {
		String temp = str;
		String rev = "";
		for(int i=temp.length()-1;i>=0;i--) {
			rev += temp.charAt(i);
		}
		
		
		String res = (rev.equals(str)) ? "Palindrome" : "Not Palindrome";
		System.out.println(res);
	}
}
