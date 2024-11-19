package arrays;
public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0; // No elements in the array
        }

        int i = 0; // Pointer to track unique elements

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++; // Move the pointer for unique elements
                arr[i] = arr[j]; // Place the next unique element
            }
        }

        return i + 1; // Number of unique elements
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4,5,5,6,7,8};
        int uniqueCount = removeDuplicates(arr);

        System.out.println("Unique Count: " + uniqueCount);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
