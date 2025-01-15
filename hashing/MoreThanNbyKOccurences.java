package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class MoreThanNbyKOccurences {

	public static void main(String[] args) {
		int arr[] = { 30, 10, 20, 20, 10, 20, 30, 30 };
		int k = 4;

		countMoreThanNByKMoreOpt(arr, k);
	}
	
	
	private static void countMoreThanNByKMoreOpt(int[] arr, int k) {

		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else if(map.size()<k-1) {
				map.put(arr[i], 1);
			}else {
				for(int keyValue : map.keySet()) {
					map.put(keyValue, map.get(keyValue)-1);
				}
			}
			
			map.entrySet().removeIf(x->x.getValue()==0);
		}
		
		// make other HashMap
		HashMap<Integer,Integer> finalCount = new HashMap<Integer, Integer>();
		for(int x : arr) {
			if(map.containsKey(x)) {
				finalCount.put(x, finalCount.getOrDefault(x,0)+1);
			}
		}
		
		for(int key : finalCount.keySet()) {
			if(finalCount.get(key)>n/k) {
				System.out.println(key);
			}
		}
	}


	public static void countMoreThanNByKOpt(int[] arr , int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int x : arr) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		int n = arr.length;
		map.forEach((key,value)->{
			if(value>n/k) {
				System.out.println(key);
			}
		});
 	}

	private static void countMoreThanNByKNaive(int[] arr, int k) {
		// Naive approach is to sort the array
		Arrays.sort(arr);
		// just count the occurence of every element\

		int i = 1;
		int count = 1;
		int n = arr.length;
		while (i < n) {

			while (i < n && arr[i] == arr[i - 1]) {
				count++;
				i++;
			}

			if (count > n / k) {
				System.out.print(arr[i - 1] + " ");
				count = 1;
			}

			i++;
		}

	}

}
