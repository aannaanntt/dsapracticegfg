package sortinggfg.recursion;
class RecursiveBubbleSort {

    // Recursive function to perform Bubble Sort
    public static void bubbleSort(int[] arr, int n) {
        // Base case: If the size of the array is 1, it is already sorted
        if (n == 1) {
            return;
        }

        // Perform one pass of bubble sort for the current size
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap if the current element is greater than the next element
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for the rest of the array (excluding the last element)
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Unsorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Call the recursive bubble sort function
        bubbleSort(arr, arr.length);

        System.out.println("\nSorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
