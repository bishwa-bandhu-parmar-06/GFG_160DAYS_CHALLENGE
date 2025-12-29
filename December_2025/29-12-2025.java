// K-th element of two Arrays
// Difficulty: MediumAccuracy: 37.4%Submissions: 383K+Points: 4Average Time: 15m
// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.



class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        // Validate k
        if (k <= 0 || k > (a.length + b.length)) {
            throw new IllegalArgumentException("Invalid k value");
        }

        int i = 0, j = 0, count = 0;
        int result = -1;

        // Merge until we reach the k-th element
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result = a[i++];
            } else {
                result = b[j++];
            }
            count++;
            if (count == k) return result;
        }

        // If elements remain in a[]
        while (i < a.length) {
            result = a[i++];
            count++;
            if (count == k) return result;
        }

        // If elements remain in b[]
        while (j < b.length) {
            result = b[j++];
            count++;
            if (count == k) return result;
        }

        return result; // Should never reach here if k is valid
    }
}