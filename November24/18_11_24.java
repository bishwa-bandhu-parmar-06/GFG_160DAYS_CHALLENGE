
// Rotate Array
// Difficulty: Medium   Accuracy: 37.06%      Submissions: 374K+     Points: 4
// Given an unsorted array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.

// Note: Consider the array as circular.


class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n = arr.length;
        d = d%n;
        if(d==0 || n<=1)
        {
            return;
        }
        reverse(arr, 0, d-1); //Reverse first d element
        reverse(arr, d, n-1); //Reverse remaining n-d element
        reverse(arr, 0, n-1); //Reverse the entire array
        
    }
    private static void reverse(int[] arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}