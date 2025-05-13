// nCr
// Difficulty: MediumAccuracy: 14.82%Submissions: 333K+Points: 4
// Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr

// A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)n that gives the number of ways to choose r objects from a set of n objects without considering the order.
// The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !
// Note: If r is greater than n, return 0.
// It is guaranteed that the value of nCr will fit within a 32-bit integer.


class Solution {
    public int nCr(int n, int r) {
        // code here
        if(r > n || r < 0){
            return 0;
        }
        
        if(r > n-r){
            r = n-r;
        }
        
        long bio_coff = 1;
        for(int i=1; i<=r; i++){
            bio_coff *= (n-i+1);
            bio_coff /=i;
        }
        return (int) bio_coff;
            
    }
}