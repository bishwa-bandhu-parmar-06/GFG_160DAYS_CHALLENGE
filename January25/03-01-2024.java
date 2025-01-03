// Count Subarrays with given XOR
// Difficulty: Medium        Accuracy: 58.86%        Submissions: 21K+         Points: 4
// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.



class Solution {
    public long subarrayXor(int arr[], int k) {
        // Map to store prefix XOR frequencies
        HashMap<Integer, Integer> prefixXorFreq = new HashMap<>();
        long count = 0; // To store the final count of subarrays
        int xor = 0; // Current prefix XOR
        
        for (int num : arr) {
            xor ^= num; // Update the current prefix XOR
            
            // Check if the current XOR equals k
            if (xor == k) {
                count++;
            }
            
            // Check if (xor ^ k) exists in the prefix map
            int target = xor ^ k;
            if (prefixXorFreq.containsKey(target)) {
                count += prefixXorFreq.get(target);
            }
            
            // Add the current XOR to the map
            prefixXorFreq.put(xor, prefixXorFreq.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}
