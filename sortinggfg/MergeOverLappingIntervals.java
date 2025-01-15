package sortinggfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverLappingIntervals {
	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] result = mergeOverLapInterval(arr);
		System.out.println("Merged intervals:");
		for (int[] interval : result) {
			System.out.println(java.util.Arrays.toString(interval));
		}
	}

	// optimal solution use sortiunfg//sort by start time incresing ordr

	static List<int[]> mergeOverlap(int[][] arr) {
		int n = arr.length;

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> res = new ArrayList<>();

		// Checking for all possible overlaps
		for (int i = 0; i < n; i++) {
			int start = arr[i][0];
			int end = arr[i][1];

			// Skipping already merged intervals
			if (!res.isEmpty() && res.get(res.size() - 1)[1] >= end) {
				continue;
			}

			// Find the end of the merged range
			for (int j = i + 1; j < n; j++) {
				if (arr[j][0] <= end) {
					end = Math.max(end, arr[j][1]);
				}
			}
			res.add(new int[] { start, end });
		}
		return res;
	}

	// this is not optimal solution
	public static int[][] mergeOverLapInterval(int[][] intervals) {
		// Edge case: if intervals is empty or has only one interval
		if (intervals.length <= 1) {
			return intervals;
		}

		// Create a list to hold merged intervals
		List<int[]> merged = new ArrayList<>();

		// Visited array to track processed intervals
		boolean[] visited = new boolean[intervals.length];

		// Traverse each interval
		for (int i = 0; i < intervals.length; i++) {
			if (visited[i])
				continue;

			// Start with the current interval
			int[] current = intervals[i];
			visited[i] = true;

			for (int j = 0; j < intervals.length; j++) {
				if (i == j || visited[j])
					continue;

				int[] next = intervals[j];

				// Check for overlap
				if (current[1] >= next[0] && current[0] <= next[1]) {
					// Merge intervals
					current[0] = Math.min(current[0], next[0]);
					current[1] = Math.max(current[1], next[1]);
					visited[j] = true;
				}
			}

			// Add merged interval to the result list
			merged.add(current);
		}

		// Convert list to array
		return merged.toArray(new int[merged.size()][]);
	}

}
