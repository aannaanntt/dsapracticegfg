package hashing;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfTwoUnsortedArray {

	public static void main(String[] args) {
		int a[] = { 15, 20, 5, 15 };
		int b[] = { 15, 15, 15, 20, 10 };
		printUnionOpt(a, b);
	}
	
	
	public static void  printUnionOpt(int a[] , int b[]) {
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer,Integer> map = new HashMap<>();
	
		for(int i : a) {
			set.add(i);
		}
		for(int j : b) {
			set.add(j);
		}
		
		System.out.println(set.size());
	}

	//naive aqpproache o(n) o(n)
	private static void printUnion(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		int temp[] = new int[m + n];
		int idx = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			temp[idx] = a[i];
			idx++;

		}

		for (int j = 0; j < b.length; j++) {
			temp[idx++] = b[j];

		}

		// print union check for dups if dups skip it
		for (int i = 0; i < temp.length; i++) {
			boolean repeated = false;
			for (int j = 0; j < i; j++) {
				if (temp[i] == temp[j]) {
					repeated = true;
					break;
				}
			}

			if (!repeated) {
				count++;
			}
		}

		System.out.print(count);

	}

}
