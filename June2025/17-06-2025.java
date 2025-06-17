// Coin Piles
// Difficulty: MediumAccuracy: 20.51%Submissions: 32K+Points: 4Average Time: 20m
// You are given an array arr[] of integers, where each element represents the number of coins in a pile. You are also given an integer k.
// Your task is to remove the minimum number of coins such that the absolute difference between the number of coins in any two updated piles is at most k.

// Note: You can also remove a pile by removing all the coins of that pile.


class Solution {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int totalLeft = 0;
        
        for (int i = 0; i < n; ++i) {
            totalLeft += (i > 0) ? arr[i-1] : 0;
            int removeRight = 0;
            int limit = arr[i] + k;

            int low = i, high = n - 1, pos = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] > limit) {
                    pos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = pos; j < n; ++j) {
                removeRight += arr[j] - limit;
            }

            ans = Math.min(ans, totalLeft + removeRight);
        }

        return ans;
    }
}