#include <iostream>
#include <algorithm> // For std::swap
#include <string>
// void reverse(int* arr, int n, int l, int r) {
//     if (l >= r) return;
    
//     std::swap(arr[l], arr[r]); // Correct way to swap elements
//     reverse(arr, n, l + 1, r - 1); // Pass incremented values correctly
// }


void reverse(int arr[], int idx,int n){
    if(idx == n/2){
        return;
    }
    std::swap(arr[idx],arr[n-(idx+1)]);
    reverse(arr,idx+1,n);
}

bool isPalin(std::string str, int idx,int n){
    if(idx >= n/2){
        return true;
    }
    if(str[idx] == str[n - (idx +1) ]){
        return isPalin(str,idx+1,n);
    }else{
        return false;
    }
}

int fibNumber(int n){
    if(n ==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    int last = fibNumber(n-1);
    int secondLast = fibNumber(n-2);
    return last + secondLast;
}
int main() {
    int arr[] = {1, 2, 3, 4, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]); // Correct way to get array size

   // reverse(arr, 0,n); // Call function with correct parameters

    // std::string str = "MADSM";
    // std::cout << isPalin(str,0,str.size());
    // Print the reversed array
    // for (int i = 0; i < n; i++) {
    //     std::cout << arr[i] << " ";
    // }

    std::cout << fibNumber(5000);
    return 0;
}
