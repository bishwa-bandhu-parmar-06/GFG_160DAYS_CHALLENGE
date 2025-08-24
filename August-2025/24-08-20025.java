// Minimum days to make M bouquets
// Difficulty: MediumAccuracy: 46.85%Submissions: 27K+Points: 4Average Time: 30m
// You have a row of flowers, where each flower blooms after a specific day. The array arr[] represents the blooming schedule: arr[i] is the day the flower at position i will bloom. To create a bouquet, you need to collect k adjacent bloomed flowers. Each flower can only be used in one bouquet.

// Your goal is to find the minimum number of days required to make exactly m bouquets. If it is not possible to make m bouquets with the given arrangement, return -1.



class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int n = arr.length;
        if(n < (m*k)){
            return -1;
        }
        Arrays.sort(arr);
        return arr[(m*k) - 1];
    }
}