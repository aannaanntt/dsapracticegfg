package bitwiseoperatos;

public class AllBitWiseOperators {

	public static void main(String[] args) {
		//andOperators(5);
		//orOperator(5);
		//xorOperator(5);
		//notOperator(5);
		//leftShiftOperator(5);
		rightShiftOperator(-5);
	}

	private static void rightShiftOperator(int i) {
//		System.out.println(Integer.toBinaryString(i));
//		System.out.println(i>>1);
//		System.out.println(Integer.toBinaryString(i));
		System.out.println(i>>>1);
		System.out.println(Integer.toBinaryString(i>>>1));
	}

	private static void leftShiftOperator(int i) {
		System.out.println(i<<1);
		
	}

	private static void notOperator(int i) {
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(~i));
		
	}

	private static void xorOperator(int i) {
		System.out.println(i^7);
		
	}

	private static void orOperator(int i) {
		System.out.println(Integer.toBinaryString(7));
		System.out.println(i|7);
		
	}

	public  static void andOperators(int i) {
		//System.out.println(Integer.toBinaryString(i));
		// 00000000 00000000 00000000 00000101
		/*
		 * AND &
		 * or |
		 * xor ^
		 * not ~
		 * left shift <<
		 * right shift >>
		 * unsigned right shift >>>
		 * 
		 * 
		 * */
		
		int c =5;
		//System.out.println(c&4);
		

	}

}
