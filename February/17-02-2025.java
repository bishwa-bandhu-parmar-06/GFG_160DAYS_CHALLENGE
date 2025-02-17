// k largest elements
// Difficulty: MediumAccuracy: 53.56%Submissions: 173K+Points: 4
// Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 


class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Sort array in ascending order
        Arrays.sort(arr);
        
        // Create an ArrayList to store the k largest elements
        ArrayList<Integer> result = new ArrayList<>();
        
        // Collect k largest elements from the end of the array
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            result.add(arr[i]);
        }
        
        return result;
    }
}