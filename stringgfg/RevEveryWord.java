package stringgfg;

public class RevEveryWord {
	
	
	public static void main(String[] args) {
		String str = "Java coding";
		
		//revWord(str);
		
		String res =revWordEffApp(str);
		System.out.println(res);
		
		
	}
	
	
	 public static String revWordEffApp(String str) {
	        int start = 0;
	        char[] charArray = str.toCharArray();
	        
	        // Reverse each word
	        for (int end = 0; end < str.length(); end++) {
	            if (charArray[end] == ' ') {
	                reverse(charArray, start, end - 1);
	                start = end + 1;
	            }
	        }
	        
	        // Reverse the last word
	        reverse(charArray, start, str.length() - 1);
	        
	        // Reverse the entire string
	        reverse(charArray, 0, str.length() - 1);
	        
	        return new String(charArray); // Convert char[] back to String
	    }

	    private static void reverse(char[] array, int start, int end) {
	        while (start < end) {
	            swap(array, start, end);
	            start++;
	            end--;
	        }
	    }

	    private static void swap(char[] array, int start, int end) {
	        char temp = array[start];
	        array[start] = array[end];
	        array[end] = temp;
	    }

	public static void revWord(String str) {
		String[] words = str.split(" ");

		String output ="";
		for(String word : words) {
			String rev ="";
			for(int i=word.length() -1;i>=0;i--) {
				rev = rev + word.charAt(i);
			}
			
			output += rev +" ";
		}
		
		for(int i=output.length() -1;i>=0;i--) {
			System.out.print(output.charAt(i));
		}
	}

}
