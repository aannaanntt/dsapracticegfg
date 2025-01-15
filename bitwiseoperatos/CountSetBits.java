package bitwiseoperatos;

public class CountSetBits {

	public static void main(String[] args) {
		int num = 9;
		int count = 0;
		
		
		
		
		while (num > 0) {
			int lastDigit = num & 1;
			if (lastDigit != 0) {
				count++;
			}

			num = num >> 1;
		}

		System.out.println(getSetBits(3));

		// System.out.println(count);
	}

	private static int getSetBits(int n) {
		int count = 0;

//		while (n > 0) {
//			count++;
//			n = n - (n & -n);
//		}
		
		System.out.println(Integer.toBinaryString(n));

		while (n > 0) {
			
			count++;
			n = n & (n - 1);
//			System.out.println(n);
		}

		return count;
	}
	static boolean checkKthBit(int n,int k) {
		 int x= (n>>(k-1));
	        if((x & 1) !=0) {
	            return true;
	        }
	        return false;
	}
	static boolean sparseNumber(int n) {
		boolean res=false;
        if((n&(n>>1))>=1){
            res=true;
            return res;
        }
        return res;
        
	}

}
