#include <iostream>
#include <algorithm>  // all lines started with # are pre processor directives

//  int cnt = 0;  
// void number(int cnt){
//     if(cnt == 4){  // Base condition to stop recursion when cnt reaches 4
//         return;
//     }
//     std::cout << cnt << std::endl;  // Print the current value of cnt
//     cnt++;  // Increment the cnt
//     number(cnt);  // Recursively call the function with the updated cnt
// }

void printName(int i, int n){
    if(i>n){
        return;
    }
    std::cout << "Anant" << std::endl;
   i=i+1;
    printName(i,n);
}

void print1toN(int n){
    if(n==0){
        return;
    }

    print1toN(n-1);
    std::cout << n << std::endl;
}


void printNto1B(int i,int n){
    if(i>n){
        return;
    }
  
  
    printNto1B(i+1,n);
    std::cout << i << std::endl;
 
}


//backtrack
void print1toNB(int i,int n){
    if(i<1){
        return;
    }

    print1toNB(i-1,n);
    std::cout << i << std::endl;
}

void factP(int i,int fact){
    if(i==1){
        std::cout << fact ;
        return;
    }
    factP(i-1,fact*i);
}

int factD(int n){
    if(n==0){
        return 1;
    }
    return n * factD(n-1);
}

 void reverse(int* arr, int n, int l ,int r){
    if(l>=r)return;
    std::swap(arr[l],arr[r]);
    reverse(arr,n,l++,r--);

}


int main(){
   // Initialize cnt to 0
//    int  n=5;int i=0;
//     printNto1B(i,n);

  // Call the recursive function
  //std::cout << factD(5);
    int arr[] = {1, 2, 3, 4, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]); // Correct way to get array size

    reverse(arr,n, 0, n - 1);

     for (int i = 0; i < n; i++) {
        std::cout << arr[i] << " ";
    }
}