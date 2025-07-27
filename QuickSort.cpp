#include <iostream>
#include <vector>

int sortAsPerPivot(int low, int high, std::vector<int>& arr) {
    int pivot = arr[high];  // Choosing the last element as the pivot
    int i = low - 1;  // Pointer for the smaller element

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            std::swap(arr[i], arr[j]);
        }
    }
    std::swap(arr[i + 1], arr[high]);  // Place pivot at its correct position
    return i + 1;  // Return pivot index
}

void quickSort(int low, int high, std::vector<int>& arr) {
    if (low < high) {  // Fix incorrect base condition
        int pivot = sortAsPerPivot(low, high, arr);
        quickSort(low, pivot - 1, arr);
        quickSort(pivot + 1, high, arr);
    }
}

void quickSortStarter(std::vector<int>& arr) {
    int low = 0, high = arr.size() - 1;
    quickSort(low, high, arr);
}

int main() {
    std::vector<int> arr = {5, 13, 6, 9, 11, 8};
    quickSortStarter(arr);

    for (auto c : arr) {
        std::cout << c << " ";  // Properly formatted output
    }
    std::cout << std::endl;  // Newline for better readability

    return 0;  // Indicate successful execution
}
