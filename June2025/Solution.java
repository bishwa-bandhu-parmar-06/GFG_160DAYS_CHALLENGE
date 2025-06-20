// Group Balls by Sequence
// Difficulty: MediumAccuracy: 39.45%Submissions: 2K+Points: 4
// You are given an array arr[] of positive integers, where each element arr[i] represents the number written on the i-th ball, and a positive integer k.
// Your task is to determine whether it is possible to rearrange all the balls into groups such that:


// Each group contains exactly k balls.
// The numbers in each group are consecutive integers


public class Solution {
    public boolean validgroup(int[] arr, int k) {
        if (arr.length % k != 0) return false;

        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        // Count frequencies
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int first = countMap.firstKey();

            for (int i = 0; i < k; i++) {
                int num = first + i;
                if (!countMap.containsKey(num)) {
                    return false;
                }
                countMap.put(num, countMap.get(num) - 1);
                if (countMap.get(num) == 0) {
                    countMap.remove(num);
                }
            }
        }

        return true;
    }
}