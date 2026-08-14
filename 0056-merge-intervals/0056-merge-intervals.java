// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: if there's 0 or 1 interval, no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by their starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        
        // Initialize with the first interval
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            // Check if the current interval overlaps with the last added interval
            if (interval[0] <= newInterval[1]) {
                // Overlapping: merge them by updating the end of the last interval
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // Non-overlapping: add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Convert the List of arrays back to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}   