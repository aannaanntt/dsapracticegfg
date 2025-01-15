package stringgfg;

import java.util.Arrays;

public class LeftMostNonRep {
	static int CHAR = 256;
	
	public static void main(String[] args) {
		String str = "geeksforgeeks"; 
		
		
		System.out.println(getLeftMostNonRepEFF2(str));
	}
	
	
	
	
	public static int getLeftMostNonRepEFF2(String str) {
	    int[] fi = new int[CHAR];
	    Arrays.fill(fi, -1);  // Initialize array with -1 to represent unvisited characters
	    
	    // First pass: track the first occurrence and mark repeating characters
	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if (fi[ch] == -1) {
	            fi[ch] = i; // First occurrence, store index
	        } else {
	            fi[ch] = -2; // Mark as repeated
	        }
	    }

	    int res = Integer.MAX_VALUE;
	    
	    // Second pass: Find the minimum index of non-repeating characters
	    for (int i = 0; i < CHAR; i++) {
	        if (fi[i] >= 0) {
	            res = Math.min(res, fi[i]); // Get the smallest index
	        }
	    }

	    return (res == Integer.MAX_VALUE) ? -1 : res; 
				
	}
	
	
	

	public static int getLeftMostNonRepEFF(String str) {
		int[] count = new int[256]; // Array for counting frequency of characters

        // Count frequencies
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        // Find the first character with count 1
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i; // Return index
            }
        }

        return -1;
	}
	

	private static int getLeftMostNonRep(String str) {
		for(int i=0;i<str.length();i++) {
			boolean isUnique = true;
			for(int j=0;j<i;j++) {
				if(i!=j && str.charAt(i) == str.charAt(j) ) {
					isUnique=false;
					break;
				}
			}
			
			if(isUnique) return str.charAt(i);
		}
		
		return -1;
		
	}

}
