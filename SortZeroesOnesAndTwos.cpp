#include <iostream>
#include <vector>
void sortArray(std::vector<int>& arr){
    int low=0; int high =arr.size()-1;
    int mid =0;
    while(mid<=high ){
        if(arr[mid] ==0){
            std::swap(arr[mid],arr[low]);
            low++;
            mid++;
        }else if(arr[mid]==1){
            mid++;
        }else{
            std::swap(arr[mid],arr[high]);
 
            high--;
        }
    }
}
int main(){
    std::vector<int> arr= {1,0,2,0,1,0,2,2};
    sortArray(arr);

    for(int x : arr){
        std::cout << x << " ";
    }

    return 0;
}