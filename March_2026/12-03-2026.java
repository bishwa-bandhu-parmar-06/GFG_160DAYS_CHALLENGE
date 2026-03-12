// Minimum K Consecutive Bit Flips
// Difficulty: HardAccuracy: 58.52%Submissions: 20K+Points: 8
// You are given a binary array arr[] (containing only 0's and 1's) and an integer k. In one operation, you can select a contiguous subarray of length k and flip all its bits (i.e., change every 0 to 1 and every 1 to 0).

// Your task is to find the minimum number of such operations required to make the entire array consist of only 1's. If it is not possible, return -1.


class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int flipCount = 0; // current parity of flips affecting this index
        int[] isFlipped = new int[n]; // marks where flips start

        for (int i = 0; i < n; i++) {
            // remove effect of a flip that ended k steps ago
            if (i >= k) {
                flipCount -= isFlipped[i - k];
            }

            // effective bit after considering flips
            int effective = (arr[i] + flipCount) % 2;

            // if it's 0, we must flip starting here
            if (effective == 0) {
                if (i + k > n) return -1; // not enough room to flip
                ans++;
                flipCount++;
                isFlipped[i] = 1; // mark that a flip started here
            }
        }

        return ans;

    }
}