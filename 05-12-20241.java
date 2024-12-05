// Sort 0s, 1s and 2s
// Difficulty: Easy       Accuracy: 50.58%        Submissions: 721K+       Points: 2
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

// Examples:

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.
// Constraints:
// 1 <= arr.size() <= 106
// 0 <= arr[i] <= 2

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        // int n = arr.length;
        // int count = 0;
        // for(int i = 0; i < n; i++){
        // while( arr[i] != 0){
        // arr[i] = 0;
        // count++;
        // }
        // while( arr[i] != 1){
        // arr[count] = 1;
        // count++;
        // }
        // while( arr[i] != 2){
        // arr[count] = 2;
        // }

        // }
        Arrays.sort(arr);
    }
}