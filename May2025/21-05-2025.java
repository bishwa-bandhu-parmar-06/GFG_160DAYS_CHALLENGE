// Kth Smallest Number in Multiplication Table
// Difficulty: HardAccuracy: 50.15%Submissions: 13K+Points: 8
// Given three integers m, n and k. Consider a grid of m * n, where mat[i][j] = i * j (1 based index). The task is to return the kth smallest element in the m * n multiplication table.




class Solution {
    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count;
    }
    public int kthSmallest(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countLessEqual(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}