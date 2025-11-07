// Weighted Job Scheduling
// Difficulty: MediumAccuracy: 67.14%Submissions: 4K+Points: 4
// Given a 2D array jobs[][] of size n × 3, where each row represents a single job with the following details:

// jobs[i][0] : Start time of the job
// jobs[i][1] : End time of the job
// jobs[i][2] : Profit earned by completing the job
// Find the maximum profit you can earn by scheduling non-overlapping jobs.

// Note: Two jobs are said to be non-overlapping if the end time of one job is less than or equal to the start time of the next job. If a job ends at time X, another job can start exactly at time X.




class Solution {
    private int binarySearch(int idx,int target,int[][] jobs){
        int n=jobs.length, res=n;
        int s=idx, e=n-1;
        
        while(s<=e){
            int mid=s+(e-s)/2;
            if(jobs[mid][0]>=target){ // is next jobs start >= target
                res=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        
        return res;
    }
    private int solve(int i, int[][] jobs, int[] dp){
        if(i>=jobs.length)return 0;
        if(dp[i]!=-1)return dp[i];
        
        int nextIdx = binarySearch(i+1,jobs[i][1],jobs); // next valid job whose s>=curr_e
        
        int take = jobs[i][2] + solve(nextIdx,jobs,dp);
        int notTake = solve(i+1,jobs,dp);
        
        return dp[i]=Math.max(take,notTake);
    }
    public int maxProfit(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        int[] dp=new int[jobs.length];
        Arrays.fill(dp,-1);
        
        return solve(0,jobs,dp);
    }
}