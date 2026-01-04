// Sort 0s, 1s and 2s
// Difficulty: MediumAccuracy: 50.58%Submissions: 835K+Points: 4Average Time: 10m
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
// Note: You need to solve this problem without utilizing the built-in sort function.


class Solution {
    public void sort012(int[] arr) {
        // code here
        int l =0 , m=0 , e = arr.length -1;
        
        while(m<=e){
            if(arr[m]==0){
                arr[m] = arr[l];
                arr[l] = 0;
                l++; m++;
            }
            else if(arr[m] == 1){
                m++;
            }
            else{
                arr[m] = arr[e];
                arr[e] = 2;
                e--;
            }
        }
    }
}