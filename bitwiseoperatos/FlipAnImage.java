package bitwiseoperatos;

import java.util.Arrays;

public class FlipAnImage {

	// reverse every row
	// invert it make 0 -> 1 & 1 -> 0

	public static void main(String[] args) {
		int image[][] = { {0,0,1}, {1,0,0}, {0,1,1} };
		System.out.println(Arrays.toString(flipImage(image)));
	}

	private static int[][] flipImage(int[][] image) {
		for (int[] row : image) {
			// reverse array
			for (int i = 0; i < (image[0].length) / 2; i++) {
				int temp = row[i] ^ 1;
				row[i] = row[image[0].length - i - 1];
				row[image[0].length - i - 1] = temp;
			}
		}

		return image;

	}

}
