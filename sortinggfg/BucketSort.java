package sortinggfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//this is to be used when data is uniformly distributed we can sort floating point numbers as well from it
public class BucketSort {

	public static void main(String[] args) {
		int[] arr = {20,80,10,85,75,99};
		int k=5;
		bucketSort(arr,k);
		
		System.out.println(Arrays.toString(arr));
	}

	public static void bucketSort(int[] arr, int k) {
		int n = arr.length;
		int max_val = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_val = Math.max(max_val, arr[i]);
		}

		max_val++;

		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < k; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n; i++) {
			int bi = (k * arr[i]) / max_val;// this expression will be able to calculate the bucket index for the element
			buckets.get(bi).add(arr[i]);
		}
		
		for(int i=0;i<k;i++) {
			Collections.sort(buckets.get(i));
		}
		int index=0;
		//merge the buckets
		for(int i=0;i<k;i++) {
			for(int j=0;j<buckets.get(i).size();j++) {
				arr[index++]=buckets.get(i).get(j);
			}
		}
		

	}

}
