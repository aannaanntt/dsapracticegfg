package arrays;
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
 
public class tuf {
 
public static void main(String args[]){  
   
      int arr[] ={10,5,9,5};
      int n = arr.length;
      countFreq(arr, n);  
  }
public static void countFreq(int arr[], int n)
{
    boolean visited[] = new boolean[n];
 
    for (int i = 0; i < n; i++) {
 
        // Skip this element if already processed
        if (visited[i] == true)
            continue;
 
        // Count frequency
        int count = 1;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                visited[j] = true;
                count++;
            }
        }
        System.out.println(arr[i] + " " + count);
    }
}
}