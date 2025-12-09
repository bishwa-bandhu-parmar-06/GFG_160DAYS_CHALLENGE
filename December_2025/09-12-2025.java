// Array Duplicates
// Difficulty: EasyAccuracy: 18.95%Submissions: 875K+Points: 2Average Time: 20m
// Given an array arr[] of size n, containing elements from the range 1 to n, and each element appears at most twice, return an array of all the integers that appears twice.

// Note: You can return the elements in any order but the driver code will print them in sorted order.

// Examples:



class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) ans.add(idx + 1);
            else arr[idx] = -arr[idx];
        }
        
        return ans;
    }
}