// Search insert position of K in a sorted array
// Difficulty: EasyAccuracy: 38.99%Submissions: 94K+Points: 2
// Given a sorted array arr[] (0-index based) of distinct integers and an integer k, find the index of k if it is present in the arr[]. If not, return the index where k should be inserted to maintain the sorted order.


class Solution {
    public int searchInsertK(int[] arr, int k) {
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] < k) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}