package arrays;

//Linear search
public class LinearSearchInArray {
	public static void main(String[] args) {
		int arr[] = { 20, 5, 7, 25 };
		System.out.println(linearSearch(arr, 0));
	}

	private static boolean linearSearch(int[] arr, int x) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				System.out.println("Element"+" " + x +" "+ "found at" + " " + (i+1) +" "+ "position");
				return true;
			}
		}

		return false;
	}
}
