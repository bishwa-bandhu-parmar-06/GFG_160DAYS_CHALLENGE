// Date : 15/11/2024
// Second Largest
// Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

//Note: The second largest element should not be equal to the largest element.

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int max = -1;
        int temp = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                temp = max;
                max = arr[i];
            }
        }
        return temp;
    }
}