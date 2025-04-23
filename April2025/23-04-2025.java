// Unique Number II
// Difficulty: MediumAccuracy: 36.9%Submissions: 161K+Points: 4Average Time: 15m
// Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas only two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.



class Solution {
    public int[] singleNum(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        // Find rightmost set bit
        int setBit = xor & -xor;

        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Return in increasing order
        return x < y ? new int[]{x, y} : new int[]{y, x};
    }
}
