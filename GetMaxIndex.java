package arrays;

public class GetMaxIndex {

	public static void main(String[] args) {
		int arr[] = { 10 ,10 };
		System.out.println(getMaxIdx(arr));
	}

	private static int getMaxIdx(int[] arr) {
		if (arr.length == 0)
			return -1;
		int maxIdx = 0;
		for (int i = 1; i < arr.length; i++) {
			if (   arr[maxIdx] < arr[i]) {
				maxIdx = i;
			}
			
		}

		return maxIdx;

	}
}
