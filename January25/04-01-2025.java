// Count all triplets with given sum in sorted array
// Difficulty: Medium         Accuracy: 48.57%         Submissions: 21K+       Points: 4
// Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            int low = i + 1, high = n - 1;

            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];

                if (sum == target) {
                    cnt++;
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return cnt;
    }
}

