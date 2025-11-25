// Game of XOR
// Difficulty: MediumAccuracy: 50.77%Submissions: 45K+Points: 4
// You are given an integer array arr[]. The value of a subarray is defined as the bitwise XOR of all elements in that subarray.
// Your task is to compute the bitwise XOR of the values of all possible subarrays of arr[].


class Solution {
    public int subarrayXor(int[] arr) {
        if(arr.length % 2 == 0)
            return 0;
        
        int xor = 0;
        
        for(int i = 0 ; i < arr.length; i += 2){
            xor ^= arr[i];
        }
        
        return xor;
    }
}
