package stackgfg;

import java.util.ArrayDeque;

public class LongestRectangularAreaHistogram {

	public static void main(String[] args) {
		int heights[] = { 6, 2, 5, 4, 1, 5, 6 };

		getMaxAreaStack(heights);
	}

	private static void getMaxAreaStack(int[] heights) {
	    // Stack to store indices of the histogram bars
	    ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
	    
	    // Variable to store the maximum area found
	    int res = 0;
	    
	    // Number of bars in the histogram
	    int n = heights.length;

	    // Iterate over all bars
	    for (int i = 0; i < n; i++) {
	        // While the current bar is shorter than the bar at the index stored at the top of the stack
	        // or if the stack is not empty
	        while (!ad.isEmpty() && heights[ad.peek()] >= heights[i]) {
	            // Pop the top of the stack and calculate the area
	            int tp = ad.pop();
	            
	            // Calculate the width:
	            // If the stack is empty, the width is from 0 to i, so the width is i.
	            // Otherwise, the width is the difference between the current index `i` and the index of the bar still in the stack.
	            int width = ad.isEmpty() ? i : i - ad.peek() - 1;
	            
	            // Calculate the area with the popped bar as the smallest bar in the rectangle
	            int curr = heights[tp] * width;
	            
	            // Update the result with the maximum area
	            res = Math.max(curr, res);
	        }
	        
	        // Push the current index to the stack
	        ad.push(i);
	    }

	    // Now, we need to pop and calculate the area for the remaining bars in the stack
	    while (!ad.isEmpty()) {
	        int tp = ad.pop();
	        
	        // Calculate the width of the remaining bars
	        int width = ad.isEmpty() ? n : n - ad.peek() - 1;
	        
	        // Calculate the area with the popped bar as the smallest bar in the rectangle
	        int curr = heights[tp] * width;
	        
	        // Update the result with the maximum area
	        res = Math.max(curr, res);
	    }
	    
	    // Output the maximum area found
	    System.out.println(res);
	}

	private static void getMaxArea(int[] heights) {
		int res = 0;
		for (int i = 0; i < heights.length; i++) {
			int curr = heights[i];
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] >= heights[i]) {
					curr += heights[i];
				} else {
					break;
				}

				for (int k = i + 1; k < heights.length; k++) {
					if (heights[j] >= heights[i]) {
						curr = curr + heights[i];
					} else {
						break;
					}
				}

				res = Math.max(curr, res);
			}
		}

		System.out.println(res);

	}
}
