package binarysearchgfg;

public class FirstOccurence {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 10, 10, 10, 20, 20, 40 };
		int occ = 20;

		System.out.println(getFirstOcuurenceRec(arr, occ, 0, arr.length - 1));
	}

	public static int getFirstOcuurenceRec(int[] arr, int element, int start, int end) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (arr[mid] > element)
			return getFirstOcuurenceRec(arr, element, start, mid - 1);
		else if (arr[mid] < element)
			return getFirstOcuurenceRec(arr, element, mid + 1, end);
		else {
			if (mid == 0 || arr[mid] != arr[mid - 1]) {
				return mid;
			} else {
				return getFirstOcuurenceRec(arr, element, start, mid - 1);
			}
		}
	}

	private static int getFirstOcuurenc(int[] arr, int occ) {

		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > occ)
				end = mid - 1;
			else if (arr[mid] < occ)
				start = mid + 1;
			else {
				if (mid == 0 || arr[mid] != arr[mid - 1]) {
					return mid;
				}
			}
		}

		return -1;

	}

}
