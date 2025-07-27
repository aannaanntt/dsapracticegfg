#include <iostream>
#include <vector>

bool printAllPermuWithSumK(int arr[], int n, int sum,std::vector<int>& ds,int idx,int k){

if(idx == n){
    //cond sat
    if(sum == k){
        for(int i=0;i<ds.size();i++){
            std::cout << ds[i] << std::endl;
           
        }
        return true;
    }
     return false;
}

    ds.push_back(arr[idx]);
    sum+=arr[idx];
    if(printAllPermuWithSumK(arr,n,sum,ds,idx+1,k) == true){
        return true;
    };
    ds.pop_back();
    sum-=arr[idx];
    if(printAllPermuWithSumK(arr,n,sum,ds,idx+1,k) == true){
        return true;
    }    
    return false;



}



int main(){
std::vector<int> ds;
    int arr[] = {3,1,2};
    int n = 3;
    int idx = 0; int sum=0; int k=4;
//    printAllPermuWithSumK(arr,n,sum,ds,idx+1,k);
    printAllPermuWithSumK(arr,n,sum,ds,idx,k);
    // generateAllPermu(arr, n, ds, idx);
    return 0;
}