// Longest Bounded-Difference Subarray
// Difficulty: MediumAccuracy: 69.14%Submissions: 7K+Points: 4
// Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
// If multiple such subarrays exist, return the one that starts at the smallest index.



class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        int l = 0, r = 0;
        int maxLen = 0, start = 0;
        
        // Deques to keep track of min and max values
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        
        while (r < n) {
            // Maintain maxDeque for maximum element in window
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[r]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(r);

            // Maintain minDeque for minimum element in window
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[r]) {
                minDeque.pollLast();
            }
            minDeque.addLast(r);

            // If the difference between max and min exceeds x, shrink the window
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                   arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                l++; // Move left pointer
                if (maxDeque.peekFirst() < l) maxDeque.pollFirst();
                if (minDeque.peekFirst() < l) minDeque.pollFirst();
            }

            // Update the longest subarray found
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }
            r++;
        }

        // Create the result subarray
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i < start + maxLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
