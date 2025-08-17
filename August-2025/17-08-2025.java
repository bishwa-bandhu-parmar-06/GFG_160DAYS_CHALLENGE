// Sort by Absolute Difference
// Difficulty: MediumAccuracy: 27.77%Submissions: 56K+Points: 4Average Time: 5m
// You are given a number x and array arr[]. Your task is to rearrange the elements of the array according to the absolute difference with x, i.e., an element having minimum difference comes first, and so on.
// Note: If two or more elements are at equal distances arrange them in the same sequence as in the given array.



class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        int n = arr.length;
        int[] temp = new int[n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        }); //{diff, i}
        
        for (int i = 0; i < n; ++i) {
            temp[i] = arr[i];
            int diff = Math.abs(arr[i] - x);
            pq.offer (new int[] {diff, i});
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            int id = pq.peek()[1];
            pq.poll();
            arr[idx++] = temp[id];
        }
    }
}