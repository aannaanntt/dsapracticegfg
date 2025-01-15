package sortinggfg;

import java.util.Arrays;

public class ChocolateDIstributionProblem {

	public static void main(String[] args) {
		int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
		int m = 3;
		System.out.println(chocDistEff(arr, m));
	}

	public static int chocDistEff(int []arr, int m) {
		int n = arr.length;
		if(m>n) {
			return -1;
		}
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int min_diff = arr[m-1] - arr[0];
		for(int i=1;i<n-m+1;i++) {
			min_diff = Math.min(min_diff, arr[i+m-1]-arr[i]);
		}
		return min_diff;
	}
	
	private static int chocDisributionNaive(int[] arr, int m) {
		int n = arr.length;
		int min_diff = Integer.MAX_VALUE;
		for (int i = 0; i < n - m; i++) {
			int min_val = Integer.MAX_VALUE;
			int max_val = Integer.MIN_VALUE;
			for (int j = i; j < i + m; j++) {
				min_val = Math.min(min_val, arr[j]);
				max_val = Math.max(max_val, arr[j]);

			}
			int diff = max_val - min_val;
			min_diff = Math.min(min_diff, diff);
		}
		return min_diff;
	}
}
