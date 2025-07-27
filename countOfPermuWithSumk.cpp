#include <iostream>
#include <vector>

int countAllPermuWithSumK(int arr[], int n, int sum,int idx,int k){

if(sum > k) return 0;
if(idx == n){
    //cond sat
    if(sum == k){
        
        return 1;
    }
     return 0;
}

 
    sum+=arr[idx];
   int first= countAllPermuWithSumK(arr,n,sum,idx+1,k);
     
    

    sum-=arr[idx];
    int second=countAllPermuWithSumK(arr,n,sum,idx+1,k);
    return first + second;

}



int main(){
std::vector<int> ds;
    int arr[] = {3,1,2};
    int n = 3;
    int idx = 0; int sum=0; int k=4;
//    printAllPermuWithSumK(arr,n,sum,ds,idx+1,k);
   std::cout << countAllPermuWithSumK(arr,n,sum,idx,k);
    // generateAllPermu(arr, n, ds, idx);
    return 0;
} 