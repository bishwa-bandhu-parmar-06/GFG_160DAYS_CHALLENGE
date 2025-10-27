// Find K Smallest Sum Pairs
// Difficulty: MediumAccuracy: 62.51%Submissions: 7K+Points: 4
// Given two integer arrays arr1[] and arr2[] sorted in ascending order and an integer k, your task is to find k pairs with the smallest sums, such that one element of each pair belongs to arr1[] and the other belongs to arr2[].

// Return the list of these k pairs, where each pair is represented as [arr1[i], arr2[j]].

// Note: You can return any possible k pairs with the smallest sums, the driver code will print true if it is correct else it will print false.


class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Min heap storing [sum, i, j]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Push the first element of arr2 with each arr1[i]
        for (int i = 0; i < Math.min(arr1.length, k); i++) {
            pq.offer(new int[]{arr1[i] + arr2[0], i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            res.add(pair);

            // Push next element in arr2 for this i
            if (j + 1 < arr2.length) {
                pq.offer(new int[]{arr1[i] + arr2[j + 1], i, j + 1});
            }
        }

        return res;
    }
}