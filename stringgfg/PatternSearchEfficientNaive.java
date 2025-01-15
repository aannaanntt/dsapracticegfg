package stringgfg;

public class PatternSearchEfficientNaive {

	
	public static void main(String[] args) {
		String text = "ABCABCDABCD";
		String pat = "ABCD";
		
		patSearch(text,pat);
		
	}

	private static void patSearch(String text, String pat) {
		int m = text.length();
		int n = pat.length();
		for(int i=0;i<=m-n;i++) {
			int j;
			for(j=0;j<n;j++) {
				if(pat.charAt(j)!=text.charAt(i+j)) {
					break;
				}
				
				if(j==m) 
					System.out.print(i);
				if(j==0)
					i++;
				else
					i=(i+j);
			}
		}
		
	}
}
