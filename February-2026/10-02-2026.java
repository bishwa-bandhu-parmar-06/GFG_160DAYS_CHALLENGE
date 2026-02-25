// Koko Eating Bananas
// Difficulty: MediumAccuracy: 50.27%Submissions: 48K+Points: 4Average Time: 20m
// Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all the bananas.

// Each hour, Koko can choose one pile and eat up to s bananas from it.

// If the pile has atleast s bananas, she eats exactly s bananas.
// If the pile has fewer than s bananas, she eats the entire pile in that hour.

// Koko can only eat from one pile per hour.


// Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.



class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        
        long max=0L;
        
        for(int c:arr)
        {
            
            max=Math.max(max,(long)c);
        }
        long left=1L;
       long right=max;
        int ans=0;
        
        while(left<=right)
        {
            long mid=left+(right-left)/2L;
            
            if(check(arr,k,mid))
            {
                ans=(int)mid%1000000007;
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] arr,int k,long mid)
    {
        double d=0.0;
        double m=(double)mid;
        for(int n:arr)
        {
            d+=Math.ceil(n/m);
            if(d>(double)k)
            return false;
        }
        return true;
    }
}