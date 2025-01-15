package sortinggfg;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = { 319, 212, 6, 8, 100, 50 };

		radixSort(arr);
		
		for(int num:arr) {
			System.out.print(num+" ");
		}
	}

	private static void radixSort(int[] arr) {
		// first find out the maximum in the array
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// this is least significant big means first number
		int exp = 1;
		while (max / exp > 0) {
			countingsort(arr, exp);
			exp = exp * 10;
		}

	}

	private static void countingsort(int[] arr, int exp) {
		int n = arr.length;
		int output[] = new int[n];
		int[] count = new int[10];//number of didigits 0-9

		// count the occurences
		for (int i = 0; i < arr.length; i++) {
			int digit = (arr[i] / exp) % 10;
			count[digit]++;
		}

		// do cumulative sum
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}
		// build output array from above sum
		for (int i = arr.length - 1; i >= 0; i--) {

			int digit = (arr[i] / exp) % 10;
			output[count[digit] - 1] = arr[i];
			count[digit]--;
		}
		
		 System.arraycopy(output, 0, arr, 0, n);

	}

}
