// #include <iostream> //header file 
// #include <math.h>
#include <iostream>
using namespace std;
// const int n = 1e7;
// int a[n];
//program start from here


void printHello(){
    cout << "Hello";
}

int sum(int a,int b){
    return a + b;
}

int printSumOfDigitsOfNum(int a,int b){
    int sum1=0; int sum2=0;
    while(a > 0 && b>0){
        int last_digit1= a %10;
        sum1+=last_digit1;
        int last_digit2= b %10;
        sum2+=last_digit2;
        a=a/10;
        b=b/10;
    }

    return sum1 + sum2;
}
int main() {
   // c++ basics 

//    cout << "Hello"<<" "<<"world";
//    cout << sqrt(16);

// //variables 
// int a =2;
// int b =3;
// int sum =a+b;
// //char ,int ,float, double , bool
// char c='a';
// double d =4.6; bool t=false;
//long int , long long int


//cout << c <<" "<< sum <<  d << t << endl;g538563
// cout << 25 % 7 << endl;

// int a =5; 
// a=++a - a++;
// char ch= 'a';
// cout << (int)ch << endl;

//int a;
// cin >> a;
// cout << a;
// cout << 7/2.0;
// cout << 'c' + 1;

// double a = 3/5;
// cout << 3 * 7 / 2 ;

//    int a = 100000;
//     double b = 100000;
//     double c = 1e24;  // 1LL ensures that the result is computed using long long
//     cout   << fixed << c << endl;  // Output will be 10000000000
    
    // int l,b;
    // cin >> l >>b; 
    // // long long int area =l * b;
    // cout  << 1LL * l * b << endl;//this will calculate  result in long long 
//    int a =3; 
//    int b =6;
//    int c=4;
//    cout << ((b>a) && (c>a)) << endl;

   // && || 

//    int a;
//    int b;
//    cin >> a >> b;
//    for(int i=a;i<=b;i++){
//     if(a==1){
//         cout << "one"<<endl;
//     }else if(a==)
//    }

//  int n;
//  cin >> n;
//  if(n %2==0){
//     cout << "YES";
//  }else{
//     cout<<"NO";
//  }

//c++ strings
// string str = "Hello";
// string str2;
// cin >> str2;
// //cout << str;
// cout << str2 +" "+ str << endl;

// // if(str == str2){
// //    cout << "YES"; 
// // }else{
// //    cout << "NO";
// // }
// str[0]='A';
// cout << str[0];

// string str1,str2;
// getline(cin , str1);
// getline(cin,str2);
// cout << "=========output=======" << endl;
// cout << str1 << endl;
// cout << str2 << endl;

//arrays

// int a[2];
// a[0]=1;
// a[1]=2;
// cout << a[12];
// int n;
// cin >>n;
// int a[n];
// for(int i=0;i<n;i++){
//     cin >> a[i];
// }

// int n; 
// cin >> n;
// char ar[n];
// int n;
// int row;
// int col;
// cin >> row;
// cin >> col;
// int a[row][col];

// for(int i=0;i<row;i++){
//     for(int j=0;j<col;j++){
//         cin >> a[i][j];
//     }
// }


// for(int i=0;i<row;i++){
//     for(int j=0;j<col;j++){
//         cout << a[i][j] << endl;
//     }
// }



// a[n-1]=34;
// cout << a[n-1];

//functions 

// cout << sum(12,23);

// cout << printSumOfDigitsOfNum(123,356);


// printHello();
}
