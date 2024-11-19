package arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = { 3, 0, 1, 2, 5 };
		System.out.println(getMaxOpt(arr));
	}

	
	
	
	public static int getMaxOpt(int[] arr) {
		 int res = 0;
		    int n = arr.length;

		    if (n < 3) {
		        return 0; // If there are less than 3 bars, no water can be trapped
		    }

		    int[] l_max = new int[n];
		    int[] r_max = new int[n];

		    // Fill l_max array
		    l_max[0] = arr[0];
		    for (int i = 1; i < n; i++) {
		        l_max[i] = Math.max(arr[i], l_max[i - 1]);
		    }

		    // Fill r_max array
		    r_max[n - 1] = arr[n - 1];
		    for (int i = n - 2; i >= 0; i--) {
		        r_max[i] = Math.max(arr[i], r_max[i + 1]);
		    }

		    // Calculate trapped water
		    for (int i = 1; i < n - 1; i++) {
		        res += Math.min(l_max[i], r_max[i]) - arr[i];
		    }

		    return res;
		
	}
	// this is on(n2)
	private static int getMaxRainWater(int[] arr) {

		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			int l_max = arr[i];
			for (int j = 0; j < i; j++) {
				l_max = Math.max(l_max, arr[j]);
			}
			
			System.out.println("Left max"+" "+l_max);

			int r_max = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				r_max = Math.max(r_max, arr[j]);
			}
			//System.out.println("Right Max"+r_max);
			res = res + Math.min(l_max, r_max) - arr[i];

		}
		return res;

	}

}
