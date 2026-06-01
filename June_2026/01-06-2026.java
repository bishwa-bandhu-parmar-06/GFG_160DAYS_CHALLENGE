// Max Product Subset
// Difficulty: MediumAccuracy: 17.21%Submissions: 89K+Points: 4
// Given an array arr[], find and return the maximum product possible with the subset of elements present in the array.

// Note:

// The maximum product can be of a single element also.
// Since the product can be large, return it modulo 109 + 7.


class Solution {
    public int findMaxProduct(int[] arr) {
        final int size = arr.length;
        
        // Size == 1
        if(size == 1) {
            return arr[0];
        }
        
        final int mod = 1000000007;
        int neg = 0;
        int zero = 0;
        int negMin = mod;
        long ans = 1;
        
        for(int val: arr) {
            if(val == 0) {
                zero++;
                continue;
            }
            if(val < 0) {
                neg++;
                negMin = Math.min(negMin, Math.abs(val));
            }
            
            ans = (1L * val * ans) % mod;
        }
        
        // Zero case or Size == 2 case
        if( (size == zero) || (size == 2 && neg == 1 && zero == 1) ) {
            return 0;
        }
        // Odd negative
        if((neg & 1) == 1) {
            ans = Math.abs(ans / (1L * negMin)) % mod;
        }
        
        return (int) ans;
    }
}