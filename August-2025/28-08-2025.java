// Maximize Number of 1's
// Difficulty: MediumAccuracy: 39.46%Submissions: 69K+Points: 4Average Time: 20m
// Given a binary array arr[] containing only 0s and 1s and an integer k, you are allowed to flip at most k 0s to 1s. Find the maximum number of consecutive 1's that can be obtained in the array after performing the operation at most k times.







class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        
        int len = 0 ; 
        int l = 0 ; 
        int r = 0 ; 
        int count = 0 ; 
        while(r<arr.length){
            if(arr[r]==0){
                count++ ; 
            }
            
            if(count<=k){
                len = Math.max(r-l+1,len);
            }
            else{
                while(count>k){
                    if(arr[l]==0){
                        count-- ; 
                    }
                    l++ ; 
                }
            }
            r++ ; 
        }
    return len ;        
    }
}