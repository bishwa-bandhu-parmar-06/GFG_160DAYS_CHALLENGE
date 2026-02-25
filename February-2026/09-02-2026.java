// Find Kth Rotation
// Difficulty: EasyAccuracy: 23.16%Submissions: 340K+Points: 2Average Time: 20m
// Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.
// Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like this:
// After 1st Rotation : [9, 2, 4, 6]
// After 2nd Rotation : [6, 9, 2, 4]


class Solution {
    public int findKRotation(int arr[]) {
        int low = 0, high = arr.length - 1;
        int ans = 0;
        int min = Integer.MAX_VALUE;

        while (low <= high) {

            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    ans = low;
                }
                break;
            }

            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    ans = low;
                }
                low = mid + 1;
            }
            else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    ans = mid;
                }
                high = mid - 1;
            }
        }
        return ans;
    }
}