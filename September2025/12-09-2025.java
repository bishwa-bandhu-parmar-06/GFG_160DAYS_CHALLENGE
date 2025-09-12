// Minimize the Heights II
// Difficulty: MediumAccuracy: 15.06%Submissions: 746K+Points: 4Average Time: 25m
// Given an array arr[] denoting heights of n towers and a positive integer k.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by k
// Decrease the height of the tower by k
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

// You can find a slight modification of the problem here.
// Note: It is compulsory to increase or decrease the height by k for each tower. After the operation, the resultant array should not contain any negative integers.



class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        
    int n = arr.length;
    Arrays.sort(arr);

    int ans = arr[n - 1] - arr[0];
    int smallest = arr[0] + k;
    int largest = arr[n - 1] - k;

    for (int i = 0; i < n - 1; i++) {
        int minVal = Math.min(smallest, arr[i + 1] - k);
        int maxVal = Math.max(largest, arr[i] + k);

        if (minVal < 0) continue;

        ans = Math.min(ans, maxVal - minVal);
    }
    return ans;
}

}
