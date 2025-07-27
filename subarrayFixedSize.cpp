#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int maxSumSubarray(vector<int>& arr, int k) {
    int windowSum = 0, maxSum = INT_MIN;
    int left = 0;

    for (int right = 0; right < arr.size(); right++) {
        windowSum += arr[right]; // Expand window

        if (right >= k - 1) { // When window size reaches k
            maxSum = max(maxSum, windowSum); // Process window
            
            windowSum -= arr[left]; // Remove left element
            left++; // Slide the window
        }
    }

    return maxSum;
}

int main() {
    vector<int> arr = {2, 1, 5, 1, 3, 2};
    int k = 3;
    cout << maxSumSubarray(arr, k) << endl; // Output: 9
    return 0;
}
