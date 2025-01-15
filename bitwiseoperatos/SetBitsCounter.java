package bitwiseoperatos;

import java.util.Arrays;

public class SetBitsCounter {
	// Precomputed table to store the count of set bits for each byte (0-255)
	private static final int[] BIT_COUNT_TABLE = new int[256];

	// Static block to initialize the lookup table
	static {
		for (int i = 1; i < 256; i++) {
			BIT_COUNT_TABLE[0]=0;
			BIT_COUNT_TABLE[i] = BIT_COUNT_TABLE[i & (i - 1)] + 1;
			
			//System.out.println(Arrays.toString(BIT_COUNT_TABLE));
		
		}
	}

	// Method to count set bits in an integer using the lookup table
	public static int countSetBits(int n) {
		return BIT_COUNT_TABLE[n & 0xFF] // Count set bits in the lowest byte
				+ BIT_COUNT_TABLE[(n >>> 8) & 0xFF] // Count set bits in the second byte
				+ BIT_COUNT_TABLE[(n >>> 16) & 0xFF] // Count set bits in the third byte
				+ BIT_COUNT_TABLE[(n >>> 24) & 0xFF]; // Count set bits in the highest byte
	}

	public static void main(String[] args) {
		int n = 29; // Binary: 0001 1101
		System.out.println("Number of set bits: " + countSetBits(n));
	}
}
