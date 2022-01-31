package com.fillipelima.general;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Use a min heap to keep on top rooms finishing earlier
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        
        // Add first end time
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0])
                minHeap.poll();
            minHeap.add(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}
