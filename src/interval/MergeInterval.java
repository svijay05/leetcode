package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // Sort the intervals based on the starting times
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // Check if the current interval overlaps with the previous one
            if (interval[0] <= currentInterval[1]) {
                // Merge the intervals by updating the end time of the current interval
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // No overlap, add the new interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convert the list of intervals to an array
        return merged.toArray(new int[merged.size()][]);
    }
}
