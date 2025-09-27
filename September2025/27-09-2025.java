// Minimum K Consecutive Bit Flips
// Difficulty: HardAccuracy: 64.29%Submissions: 9K+Points: 8
// You are given a binary array arr[] (containing only 0's and 1's) and an integer k. In one operation, you can select a contiguous subarray of length k and flip all its bits (i.e., change every 0 to 1 and every 1 to 0).

// Your task is to find the minimum number of such operations required to make the entire array consist of only 1's. If it is not possible, return -1.


class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
           
        int n = arr.length;
        int[] flipped = new int[n]; 
        int flip = 0;               
        int operations = 0;

        for (int i = 0; i < n; i++) {
           
            if (i >= k) {
                flip ^= flipped[i - k];
            }
                if ((arr[i] ^ flip) == 0) {
                if (i + k > n) return -1; 
                operations++;
                flip ^= 1;         
                flipped[i] = 1;    
            }
        }
        return operations;
    }
}
