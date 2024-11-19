package arrays;

public class FreqInArraySorted {

	public static void main(String[] args) {
		int arr[] = { 56,10, 10, 10, 25, 30, 30,89};
		countFreq(arr);
	}

	private static void countFreq(int[] arr) {
		int i = 1;
		int n = arr.length;
		int freq =1;
		while (i < n) {
			while(i<n && arr[i] == arr[i-1]) {
				freq++;
				i++;
			}
			
			System.out.println(arr[i-1]+" "+freq);
			i++;
			freq=1;
		}
		
		if(n==1 || arr[n-1] != arr[n-2]) {
			System.out.println(arr[n-1] +" "+freq);
		}

	}
}
