// K-th Largest Sum Contiguous Subarray
// Difficulty: MediumAccuracy: 54.33%Submissions: 31K+Points: 4Average Time: 20m
// Given an array arr[] of size n, find the sum of the K-th largest sum among all contiguous subarrays. In other words, identify the K-th largest sum from all possible subarrays and return it.


class Solution {
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        int[] cumulativeSums = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                cumulativeSums[index++] = sum;
            }
        }
        Arrays.sort(cumulativeSums);
        return cumulativeSums[cumulativeSums.length - k];
    }
}