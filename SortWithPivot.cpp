#include<iostream>
#include<vector>


void sortAsPerPivot(std::vector<int>& arr, int pivot){
    int low =0; int high =arr.size()-1; int mid =0;
    while(mid<=high){
        if(arr[mid]<=pivot){
            std::swap(arr[mid],arr[low]);
            low++;
            mid++;
        }
        else{
            std::swap(arr[mid],arr[high]);
            high--;
        }
    }
}

int main(){
    std::vector<int> arr = {7,5,2,9,10,20,-1,3,4};
    int pivot =4;
    sortAsPerPivot(arr,pivot);
     for(auto x : arr){
        std::cout << x << " ";
    }

    return 0;
}