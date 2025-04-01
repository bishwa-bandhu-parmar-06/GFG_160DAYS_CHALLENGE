// Minimize the Heights I
// Difficulty: Medium    Accuracy: 26.16%      Submissions: 92K+     Points: 4
// Given a positive integer k and an array arr[] denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.
// Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

// Note: A slight modification of the problem can be found here. 

class Solution {
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            int min = Math.min(arr[0] + k, arr[i] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}