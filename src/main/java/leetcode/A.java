package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class A {
    public static void main(String[] args) {

    }

    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));

        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    public int minMeetingRooms1(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        for (int[] interval : intervals) {
            pq.offer(new int[]{interval[0], 1});
            pq.offer(new int[]{interval[1], -1});
        }
        int count = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            count += pq.poll()[1];
            max = Math.max(max, count);
        }
        return max;
    }

}
