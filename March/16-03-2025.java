// Minimum Jumps
// Difficulty: MediumAccuracy: 11.91%Submissions: 970K+Points: 4
// You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

// For example:

// If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
// If arr[i] = 0, you cannot jump forward from that position.
// Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

// Note:  Return -1 if you can't reach the end of the array.


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        if (n == 1) return 0; // Already at the last index
        if (arr[0] == 0) return -1; // Can't move forward
        
        int jumps = 0, farthest = 0, currEnd = 0;
        
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]); // Update the farthest reachable index
            
            if (i == currEnd) { // Need to make a jump
                jumps++;
                currEnd = farthest;
                
                if (currEnd >= n - 1) return jumps; // Reached the last index
            }
        }
        
        return -1; // If we never reach the last index
    }
}
