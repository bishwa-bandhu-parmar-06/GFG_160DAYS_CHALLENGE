// Unique Number III
// Difficulty: MediumAccuracy: 49.87%Submissions: 58K+Points: 4Average Time: 20m
// Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
// Find that element which occurs once.

class Solution {
    public int getSingle(int[] arr) {
        int result = 0;

        // Loop through 32 bits
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            // Count number of elements with i-th bit set
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    sum++;
                }
            }

            // If the count of bits at position i is not multiple of 3,
            // then the single element has a set bit at this position
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }
}
