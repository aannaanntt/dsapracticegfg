package arrays;

import java.util.Arrays;

public class NextPermu {

    public static void main(String[] args) {
        int arr[] = { 3,2,1 };
        System.out.println(Arrays.toString(printNextPermu(arr)));
    }

    private static int[] printNextPermu(int[] arr) {
        int n = arr.length;
        int idx = -1;

        // Step 1: Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) { // Change to "arr[i] < arr[i + 1]"
                idx = i;
                break;
            }
        }

        // Step 2: If no such element exists, reverse the array (last permutation)
        if (idx == -1) {
            return reverse(arr, 0, n - 1);
        }

        // Step 3: Find the next greater element on the right of idx and swap
        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }

        // Step 4: Reverse the array from idx+1 to the end
        return reverse(arr, idx + 1, n - 1);
    }

    private static int[] reverse(int[] arr, int start, int end) {
        while (start < end) { // Correct loop condition
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
