// Find Only Repetitive Element from 1 to n-1
// Difficulty: EasyAccuracy: 63.0%Submissions: 10K+Points: 2
// Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The array has only one repetitive element. Your task is to find the repetitive element.

// Note: It is guaranteed that there is a repeating element present in the array.


class Solution {
    public int findDuplicate(int[] arr) {
        // Floyd's Tortoise and Hare algorithm
        int slow = arr[0];
        int fast = arr[0];

        // Phase 1: Detect the cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}
