// Maximum Sum Problem
// Difficulty: EasyAccuracy: 57.09%Submissions: 69K+Points: 2
// Given a number n, find its maximum sum value with 3 recursive breaks described below.

// Break into three parts n/2, n/3, and n/4 (consider only the integer part or floor value).
// Each number obtained in this process can be divided further recursively. 
// At every step,  we can take the max of current value of n or the max value obtained with recursive process.
// It is possible that we don't divide the number at all and choose it as final answer.
// Examples:

// Input: n = 12
// Output: 13
// Explanation: Break n = 12 in three parts [12/2, 12/3, 12/4] = [6, 4, 3], now current sum is = (6 + 4 + 3) = 13. Further breaking 6, 4 and 3 into parts will produce sum less than or equal to 6, 4 and 3 respectively.
// Input: n = 24
// Output: 27
// Explanation: Break n = 24 in three parts [24/2, 24/3, 24/4] = [12, 8, 6], now current sum is = (12 + 8 + 6) = 26 . But recursively breaking 12 would produce value 13. So our maximum sum is 13 + 8 + 6 = 27.
// Constraints:
// 0  ≤ n  ≤ 106

class Solution {
    public int maxSum(int n) {
        // code here.
        
        if(n==0)
        return 0;
        int[]dp = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dp[i]=-1;
        }
        
     helper(n,dp);
     return dp[n];
    }
    
    public int helper(int n,int[]arr)
    {
        if(n==0)
        return 0;
        
        if(arr[n]!=-1)
        return arr[n];
        
        int temp=helper(n/2,arr)+helper(n/3,arr)+helper(n/4,arr);
        
        int ans=Math.max(n,temp);
        
        arr[n]=ans;
        
        return ans;
    }
}

