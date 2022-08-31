package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length; // n <= m
        int m = bikes.length;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> {
            if (a.distance != b.distance) return a.distance - b.distance;
            if (a.worker != b.worker) return a.worker - b.worker;
            return a.bike - b.bike;
        });
        int[] assignment = new int[n];
        Set<Integer> workerPool = new HashSet<>();
        Set<Integer> bikePool = new HashSet<>();
        for (int i = 0; i < n; i++) workerPool.add(i);
        for (int i = 0; i < m; i++) bikePool.add(i);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Pair p = new Pair(i, j, workers[i], bikes[j]);
                heap.offer(p);
            }
        }
        while (workerPool.size() > 0) {
            Pair p = heap.poll();
            if (workerPool.contains(p.worker) && bikePool.contains(p.bike)) {
                assignment[p.worker] = p.bike;
                workerPool.remove(p.worker);
                bikePool.remove(p.bike);
            }
        }
        return assignment;
    }

    private int manhattanDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    class Pair {
        int worker;
        int bike;
        int distance;

        Pair(int worker, int bike, int[] wc, int[] bc) {
            this.worker = worker;
            this.bike = bike;
            distance = manhattanDistance(wc, bc);
        }
    }
}