package sortinggfg.recursion;
class RecursiveInsertionSort {

    // Recursive function to perform insertion sort
    public static void insertionSort(int[] arr, int n) {
        // Base case: If the size is 1, the array is already sorted
        if (n <= 1) {
            return;
        }

        // Sort the first n-1 elements
        insertionSort(arr, n - 1);

        // Insert the last element of the array at its correct position
        int last = arr[n - 1];
        int j = n - 2;

        // Shift elements of the sorted part to make space for the last element
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }

        // Place the last element in its correct position
        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Unsorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Call the recursive insertion sort function
        insertionSort(arr, arr.length);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
