#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int minSubArrayLen(int target, vector<int>& arr) {
    int left = 0, windowSum = 0, minLength = INT_MAX;

    for (int right = 0; right < arr.size(); right++) {
        windowSum += arr[right]; // Expand window

        while (windowSum >= target) { // Shrink window if condition met
            minLength = min(minLength, right - left + 1);
            windowSum -= arr[left]; // Remove left element
            left++; // Slide the window
        }
    }

    return (minLength == INT_MAX) ? 0 : minLength;
}

int main() {
    vector<int> arr = {2, 3, 1, 2, 4, 3};
    int target = 7;
    cout << minSubArrayLen(target, arr) << endl; // Output: 2
    return 0;
}
