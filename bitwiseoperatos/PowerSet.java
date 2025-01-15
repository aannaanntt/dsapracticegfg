package bitwiseoperatos;

public class PowerSet {

	public static void main(String[] args) {
		String str = "abc";
		int n = str.length();
		int noOfSubsets = 1 << n;
		for (int i = 0; i < noOfSubsets; i++) {
			for (int j = 0; j < n; j++) {
				if((i & (1<<j)) !=0) {
					System.out.print(str.charAt(j));
				}
				
			}
			System.out.println();
		}
	}

} 
