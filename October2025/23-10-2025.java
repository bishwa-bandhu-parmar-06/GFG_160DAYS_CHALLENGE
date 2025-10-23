// K Closest Points to Origin
// Difficulty: MediumAccuracy: 62.4%Submissions: 27K+Points: 4
// Given an integer k and an array of points points[][], where each point is represented as points[i] = [xi, yi] on the X-Y plane. Return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance, defined as:
// distance = sqrt( (x2 - x1)2 + (y2 - y1)2 )

// Note: You can return the k closest points in any order, the driver code will print them in sorted order.
// Test Cases are generated such that there will be a unique ans.


class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        
        for (int[] ref : points) {
            int cal = (int)Math.pow(ref[0],2) + (int)Math.pow(ref[1],2);

            if (pq.size() < k) {
                pq.offer(new int[]{cal, ref[0], ref[1]});
            } else if (pq.peek()[0] > cal) {
                pq.poll();
                pq.offer(new int[]{cal, ref[0], ref[1]});
            }
        }
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(top[1], top[2])));
        }
        
        return res;
    }
}