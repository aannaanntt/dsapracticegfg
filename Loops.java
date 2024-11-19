package arrays;

public class Loops {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int n = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				System.out.println((i + j)%n);
				// System.out.println(i + "---->" + j);
				// break;
			}

		}

		// System.out.println(3%4);
	}

}
