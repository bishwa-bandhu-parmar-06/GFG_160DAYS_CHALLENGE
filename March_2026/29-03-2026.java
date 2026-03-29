// Partitions with Given Difference
// Difficulty: MediumAccuracy: 36.76%Submissions: 234K+Points: 4Average Time: 20m
// Given an array arr[] and an integer diff, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

// Note: A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

class Solution {
    public int countPartitions(int[] arr, int diff) {
        // code here
        int n =  arr.length;
        int sum = 0;
        for(int i = 0;i<n;i++) sum+=arr[i];
        if(diff>sum) return 0;
        if ((sum + diff) % 2 != 0) return 0;

        int s2 = (sum+diff)/2;
        int [][]dp =  new int [n+1][s2+1];
        for(int i = 0;i<=n;i++) dp[i][0]=1;
        //for(int j=  1;j<=s2;j++) dp[0][j]=0;
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=s2;j++){
                if(arr[i-1]>j) dp[i][j]= dp[i-1][j];
                 else  dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                
            }
        }
            return dp[n][s2];
        
    }
}