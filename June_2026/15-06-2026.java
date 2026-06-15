// Minimum Cost to Fill Given Weight
// Difficulty: MediumAccuracy: 25.56%Submissions: 75K+Points: 4
// Given a bag of size w kg and you are provided costs of packets different weights of oranges in array cost[], find the minimum total cost to buy exactly w kg oranges

// The cost of 1 kg orange is present at index 0 and in general arr[i] has cost of (i+1) kg orange.
// cost[i] = -1 means that 'i+1' kg packet of orange is unavailable.
// If it is not possible to buy exactly w kg oranges then return -1. It may be assumed that there is an infinite supply of all available packet types.


class Solution {

    public int minimumCost(int[] cost, int w) {

        int[]dp=new int[w+1];

        for(int i=0;i<w+1;i++)

        dp[i]=(int)1e5+1;

        dp[0]=0;

        int n=cost.length;

        for(int i=0;i<n;i++){

            if(cost[i]==-1){

            continue;

            }

            int wt=i+1;

        for(int cur=wt;cur<=w;cur++){

            if(dp[cur-wt]!=(int)1e5+1)

                

                dp[cur]=Math.min(dp[cur],dp[cur-wt]+cost[i]);

            

        }

        }

       return (dp[w]==(int)1e5+1)?-1:dp[w];

    }

}