package sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int array[] = {5,3,8,4,2,7,1,10};
		q_sort_hoares(array,0,array.length-1);
		System.out.print(Arrays.toString(array));
	}
	
	
	

	public static void q_sort_hoares(int[] array,int low_pointer,int high_pointer) {
		if(low_pointer<high_pointer) {
			int p =hoares_partition(array, low_pointer, high_pointer);
			q_sort_hoares(array, low_pointer, p);
			q_sort_hoares(array,p+1,high_pointer);
		}
	}
	
	public static void q_sort(int [] array,int low_pointer,int high_pointer) {
		if(low_pointer<high_pointer) {
			int p = lomuto_partition(array, low_pointer, high_pointer);
			q_sort(array,low_pointer,p-1);
			q_sort(array,p+1,high_pointer);
		}
		
	}
	
	
	
	
	public static int hoares_partition(int[] array, int lowPointer, int highPointer) {
	    int pivot = array[lowPointer];
	    int i = lowPointer - 1, j = highPointer + 1;

	    while (true) {
	        do {
	            i++;
	        } while (array[i] < pivot);

	        do {
	            j--;
	        } while (array[j] > pivot);

	        if (i >= j) {
	            return j;
	        }

	        swap(array, i, j);
	    }
	}

	
	static void swap(int[] array , int first_element,int second_element) {
		int temp = array[first_element];
		array[first_element]=array[second_element];
		array[second_element]=temp;
	}
	
	
	
	public static int lomuto_partition(int[] array,int low_pointer,int high_pointer) {
		int pivot = array[high_pointer];
		int i=low_pointer-1;
		for(int j=low_pointer;j<high_pointer;j++) {
			if(array[j]<=pivot) {
				i++;
				swap(array,i,j);
			}
			
		}
		
		swap(array,i+1,high_pointer);
		
		return i+1;
	}

	private static int[] naivePartitioning(int[] array, int low_pointer, int high_pointer, int pivot) {
		int temp[] = new int[high_pointer-low_pointer+1];
		int index=0;
		for(int i=low_pointer;i<=high_pointer;i++) {
			if( i!= pivot && array[i]<=array[pivot] ) {
				temp[index]=array[i];
				index++;	
			}
		
		
		}
		
		temp[index]=array[pivot];
		index++;
		
		for(int i=low_pointer;i<=high_pointer;i++) {
			if(i!= pivot &&array[i]>array[pivot]) {
				temp[index]=array[i];
				index++;
			}
		}
		
		for(int i=low_pointer;i<=high_pointer;i++) {
			array[i]=temp[i-low_pointer];
		}
		return array;
	}

}
