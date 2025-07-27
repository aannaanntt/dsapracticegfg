#include <iostream>
#include <vector>

void generateAllPermu(int arr[], int n, std::vector<int>& ds, int idx) {
    if (idx == n) {
        for (int i = 0; i < n; i++) {
            std::cout << ds[i] << " ";
        }
        std::cout << std::endl;  // Print newline for clarity
        return;
    }

     // Base case to avoid out-of-bounds access

    // Pick the current element
    ds.push_back(arr[idx]);
    generateAllPermu(arr, n, ds, idx + 1);

    // Backtrack: Remove the last element
    ds.pop_back();
    generateAllPermu(arr, n, ds, idx + 1);
}

void printAllPermuWithSumK(int arr[], int n, int sum,std::vector<int>& ds,int idx,int k){

if(idx == n){
    if(sum == k){
        for(int i=0;i<ds.size();i++){
            std::cout << ds[i] << std::endl;
        }
       
    }
     return;
}

    ds.push_back(arr[idx]);
    sum+=arr[idx];
    printAllPermuWithSumK(arr,n,sum,ds,idx+1,k);
    ds.pop_back();
    sum-=arr[idx];
    printAllPermuWithSumK(arr,n,sum,ds,idx+1,k);    




}

int main() {
    std::vector<int> ds;
    int arr[] = {3,1,2};
    int n = 3;
    int idx = 0; int sum=0; int k=4;
//    printAllPermuWithSumK(arr,n,sum,ds,idx+1,k);
    printAllPermuWithSumK(arr,n,sum,ds,idx,k);
    // generateAllPermu(arr, n, ds, idx);
    return 0;
}
