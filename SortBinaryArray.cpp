#include <iostream>
#include <vector>

void sortBinaryArray(std::vector<int>& arr) {
    int low = 0; 

    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == 0) {
            std::swap(arr[i], arr[low]); 
            low++; 
        }
    }
}

int main() {
    std::vector<int> arr = {1, 0, 0, 1, 0};

    sortBinaryArray(arr);

    for (int num : arr) {
        std::cout << num << " "; 
    }
    return 0;
}
