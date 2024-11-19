package arrays;
import java.util.ArrayList;
import java.util.List;

public class MinimumFlipsWithRanges {
    public static void findFlips(int[] arr) {
        int n = arr.length;

        // Identify groups of 0s and 1s
        for (int i = 1; i < n; i++) {
            // Check for the start of a new group
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0]) {
                    System.out.print("From " + i + " ");
                } else {
                    System.out.println("to " + (i - 1));
                }
            }
        }

        // Handle the last group if it needs flipping
        if (arr[n - 1] != arr[0]) {
            System.out.println("to " + (n - 1));
        }
    }

    public static void main(String[] args) {
        int[] binaryArray = {1, 1, 0, 0, 0, 1,0};
        findFlips(binaryArray);
    }
}
