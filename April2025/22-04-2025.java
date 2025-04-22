// Unique Number I
// Difficulty: EasyAccuracy: 68.66%Submissions: 9K+Points: 2
// Given a unsorted array arr[] of positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

// Examples :

class Solution {
    public int findUnique(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
