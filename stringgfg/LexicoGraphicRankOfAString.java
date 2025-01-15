package stringgfg;

public class LexicoGraphicRankOfAString {
	
	static final int CHAR = 256;
	public static void main(String[] args) {
		String str = "STRING";
		System.out.println(getLexRank(str));
	}
	
	public static int getFact(int n) {
		if(n==0) {
			return 1;
		}
		
		return n*getFact(n-1);
	}
	private static int getLexRank(String str) {
		int res =1;
		int n = str.length();
		int mul = getFact(n);
		int [] count = new int[LexicoGraphicRankOfAString.CHAR];
		for(int i=0;i<n;i++) {
			count[str.charAt(i)]++;
		}//this will count frequency of every character in string
		
		//calculate the weighted sum
		for(int i=1;i<CHAR;i++) {
			count[i]+=count[i-1];
		}//this will let us know how many characters are smaller than current character
		
		//now in every iteration we have to do sum of factorial
		
		for(int i=0;i<n;i++) {
			mul = mul / (n - i); // this will reduce the value of factorial as we move forward
			
			res = res + count[str.charAt(i) -1] * mul; // this is the formula to get smaller number rank from current character 
			
			for(int j = str.charAt(i) ; j < CHAR;j++) {
				count[j]--; // doing this so that the count of current character is reduced
			}
		}
		return res;
	}
}
