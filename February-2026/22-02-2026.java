// Count Subarrays with given XOR
// Difficulty: MediumAccuracy: 58.86%Submissions: 82K+Points: 4
// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Note: It is guranteed that the total count will fit within a 32-bit integer.









class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int prefixXor = 0;

        for (int num : arr) {
            prefixXor ^= num;

            // Case 1: subarray from start has XOR = k
            if (prefixXor == k) {
                count++;
            }

            // Case 2: subarray ending here has XOR = k
            int target = prefixXor ^ k;
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            // Update frequency of prefixXor
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;

    }
}