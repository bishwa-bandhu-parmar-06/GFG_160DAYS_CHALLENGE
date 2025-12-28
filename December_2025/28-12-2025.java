// Minimum time to fulfil all orders
// Difficulty: HardAccuracy: 63.04%Submissions: 13K+Points: 8
// Geek is organizing a party at his house. For the party, he needs exactly n donuts for the guests. Geek decides to order the donuts from a nearby restaurant, which has m chefs and each chef has a rank r.
// A chef with rank r can make 1 donut in the first r minutes, 1 more donut in the next 2r minutes, 1 more donut in the next 3r minutes, and so on.
// For example, a chef with rank 2, can make one donut in 2 minutes, one more donut in the next 4 minutes, and one more in the next 6 minutes. So, it take 2 + 4 + 6 = 12 minutes to make 3 donuts. A chef can move on to making the next donut only after completing the previous one. All the chefs can work simultaneously.
// Since, it's time for the party, Geek wants to know the minimum time required in completing n donuts. Return an integer denoting the minimum time.


class Solution {
    public boolean isPossible(int[] ranks,int mid,int n){
        int ans=0;
        for(int i:ranks){
            int mul=i;
            int start=1;
            int end=n;
            int temp=0;
            while(start<=end){
                int midd=start+(end-start)/2;
                if((midd*(midd+1)/2)*mul<=mid){
                    temp=midd;
                    start=midd+1;
                }
                else end=midd-1;
            }
            ans+=temp;
            if(ans>=n)
            return true;
            
        }
        return false;
    }
    public int minTime(int[] ranks, int n) {
        // code here
        Arrays.sort(ranks);
        int len=ranks.length;
        int min=0;
        int max=ranks[len-1]*((n*(n+1))/2);
        int ans=Integer.MAX_VALUE;
        while(min<=max){
            int mid=min+(max-min)/2;
            if(isPossible(ranks,mid,n)){
                ans=Math.min(mid,ans);
                max=mid-1;
            }
            else min=mid+1;
        }
        return ans;
        
    }
}