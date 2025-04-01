// K Closest Points to Origin
// Difficulty: MediumAccuracy: 62.4%Submissions: 13K+Points: 4
// Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance, defined as: 

// sqrt( (x2 - x1)2 + (y2 - y1)2 )

// Note: You can return the k closest points in any order, driver code will sort them before printing.



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max heap to store points based on their distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                (b[0] * b[0] + b[1] * b[1]), 
                (a[0] * a[0] + a[1] * a[1])
            )
        );

        // Add points to the heap
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        // Prepare the result
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}