package sorting;

public class UnionOfArray {

	public static void main(String[] args) {
		int array1[] = { 3, 5, 8 };
		int array2[] = { 2, 8, 9, 10, 15 };
		printUnion(array1, array2);
	}

	private static void printUnion(int[] array1, int[] array2) {
		int m = array1.length;
		int n = array2.length;
		int i = 0, j = 0;
		while (i < m && j < n) {

			if (i > 0 && array1[i] == array1[i - 1]) {
				i++;
				continue;
			}
			if (j > 0 && array2[j] == array2[j - 1]) {
				j++;
				continue;
			}
			if (array1[i] < array2[j]) {
				System.out.print(array1[i]);
				i++;
			} else if (array2[j] < array1[i]) {
				System.out.print(array2[j]);
				j++;
			} else {
				System.out.print(array1[i]);
				i++;
				j++;
			}
		}

		while (i < m) {
			if(i>0 && array1[i]==array1[i-1]) {i++;continue;}
			System.out.print(array1[i]);
			i++;
		}
		while (j < n) {
			if(j>0 && array2[j]==array2[j-1]) {j++;continue;}
			System.out.print(array2[j]);
			j++;
		}

	}

}
