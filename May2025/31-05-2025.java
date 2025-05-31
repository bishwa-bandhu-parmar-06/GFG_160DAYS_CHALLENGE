/*Kth element in Matrix
Difficulty: MediumAccuracy: 61.42%Submissions: 66K+Points: 4Average Time: 35m
Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.*/

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        int n = mat .length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);  // {mat[i][j], i, j}
        for(int i=0; i<n; i++)
            pq.offer(new int[]{mat[i][0], i, 0});
        
        while(--k>0){
            int[] curr = pq.poll();
            if(curr[2]+1<n) pq.offer(new int[]{mat[curr[1]][curr[2]+1], curr[1], curr[2]+1});
        }
        return pq.peek()[0];
    }
}
