package stackgfg;

import java.util.ArrayDeque;

public class LargestRectangleWithAllOnes {
	
	public static void main(String[] args) {
		int[][] arr = {{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
		maximalRectangleStack(arr);
	}
	
	private static void maximalRectangleStack(int[][] arr) {
	    int res = 0;
	    if (arr == null || arr.length == 0 || arr[0].length == 0) {
	        System.out.println(res); // If matrix is empty
	        return;
	    }
	    
	    int m = arr.length;  // Number of rows
	    int n = arr[0].length;  // Number of columns
	    
	    // Heights array that will represent histogram bars for each row
	    int[] heights = new int[n];
	    
	    // Process each row
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            // If the cell contains 1, add it to the height
	            // If the cell contains 0, reset the height to 0
	            heights[j] = (arr[i][j] == 0) ? 0 : heights[j] + 1;
	        }
	        
//	        for(int m1=0;m1<heights.length;m1++) {
//	        	System.out.print(heights[m1]+" ");
//	        }
//	        
	        // Calculate the maximum area for the histogram (using the row as the base)
	        res = Math.max(res, getMaxAreaStack(heights));
	    }
	    
	    // Output the maximum area found
	  //  System.out.println(res);
	}

	// Logic for calculating the maximum area in a histogram
	private static int getMaxAreaStack(int[] heights) {
	    ArrayDeque<Integer> ad = new ArrayDeque<>();
	    int res = 0;
	    int n = heights.length;
	    
	    // Iterate through all bars (heights)
	    for (int i = 0; i < n; i++) {
	        // While the current bar is smaller than the bar at the stack's top
	        while (!ad.isEmpty() && heights[ad.peek()] >= heights[i]) {
	            int tp = ad.pop();
	            int width = ad.isEmpty() ? i : i - ad.peek() - 1;
	            int curr = heights[tp] * width;
	            res = Math.max(curr, res);
	        }
	        ad.push(i);
	    }
	    
	    // Pop remaining bars and calculate area
	    while (!ad.isEmpty()) {
	        int tp = ad.pop();
	        int width = ad.isEmpty() ? n : n - ad.peek() - 1;
	        int curr = heights[tp] * width;
	        res = Math.max(curr, res);
	    }
	    
	    return res;
	}

	 public static void maximalRectangle(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int maxArea = 0;  // Variable to store the maximum area of rectangle
	        
	        // Loop through each possible top-left corner
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                // Start with the current cell and try to find the largest rectangle
	                if (matrix[i][j] == 1) {
	                    // Try every possible bottom-right corner starting from (i,j)
	                    for (int x = i; x < m; x++) {
	                        for (int y = j; y < n; y++) {
	                            // Check if the rectangle formed by (i,j) and (x,y) is valid (all 1's)
	                            boolean validRectangle = true;
	                            for (int p = i; p <= x; p++) {
	                                for (int q = j; q <= y; q++) {
	                                    if (matrix[p][q] == 0) {
	                                        validRectangle = false;
	                                        break;
	                                    }
	                                }
	                                if (!validRectangle) break;
	                            }
	                            
	                            // If valid, calculate area and update maxArea
	                            if (validRectangle) {
	                                int area = (x - i + 1) * (y - j + 1);
	                                maxArea = Math.max(maxArea, area);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        // Return the maximum area found
	       System.out.println(maxArea);
	    }
}
