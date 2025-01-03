
// Subarrays with sum K
// Difficulty: Medium         Accuracy: 49.74%         Submissions: 54K+       Points: 4
// Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.


class Solution {
    public int countSubarrays(int[] arr, int k) {
        // HashMap to store prefix sums and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initial values
        map.put(0, 1); // To handle subarrays equal to k starting from index 0
        int prefixSum = 0;
        int count = 0;

        // Traverse the array
        for (int num : arr) {
            prefixSum += num; // Update the prefix sum

            // Check if (prefixSum - k) exists in the map
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k); // Add the frequency of (prefixSum - k)
            }

            // Update the frequency of the current prefixSum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count; // Return the total count of subarrays
    }
}