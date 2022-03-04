package com.fillipelima.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeIntervals {
    
    // 5ms - 95.31%
    public int[][] mergeOptimized(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.stream().toArray(int[][]::new);
    }    
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Queue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[1] - a[1]);
        maxHeap.add(intervals[0]);        
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = maxHeap.poll();
            if (curr[1] >= intervals[i][0]) {
                if (curr[1] <= intervals[i][1])
                    curr[1] = intervals[i][1];
            }else{
                maxHeap.add(intervals[i]);
            }
            maxHeap.add(curr);                                 
        }
        return maxHeap.stream().toArray(int[][]::new);
    }    
    
}
