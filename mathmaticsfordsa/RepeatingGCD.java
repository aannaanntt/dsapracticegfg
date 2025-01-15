package mathmaticsfordsa;


//optimized approach is first find GCD of length and than repeat N gcd(length) times; 
public class RepeatingGCD {
	public static long calcGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return calcGCD(b, a % b);
    }

    // Function to form a number by repeating N 'rep' times
    public static long makeNum(long N, long rep) {
        long result = 0;
        for (int i = 1; i <= rep; i++) {
            result = result * 10 + N;
        }
        return result;
    }

    // Function to calculate GCD of numbers formed by repeating N 'x' and 'y' times
    public static String FindGcd(long N, int x, int y) {
    	
    	
    	int len1= x ;
    	int len2 =y;
    	long lengthGCD=calcGCD(len1, len2);

        // Return GCD of the two numbers
        return String.valueOf(makeNum(N, lengthGCD));
    }
    
    public static void main(String[] args) {
		System.out.println(FindGcd(623856 , 164, 750));
	}
}
