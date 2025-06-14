// Koko Eating Bananas
// Difficulty: MediumAccuracy: 50.27%Submissions: 35K+Points: 4Average Time: 20m
// Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all the bananas.

// Each hour, Koko can choose one pile and eat up to s bananas from it.

// If the pile has atleast s bananas, she eats exactly s bananas.

// If the pile has fewer than s bananas, she eats the entire pile in that hour.

// Koko can only eat from one pile per hour.


// Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k hours.

// Examples:


class Solution {
    public int kokoEat(int[] arr, int k) {
        
        int maxi=0;
        for(int i:arr) maxi=Math.max(i,maxi);
        
        int low=1,high=maxi,res=Integer.MAX_VALUE;
        
        while(low<=high){
            int mid=low+(high-low)/2;
           
            if(isPossible(mid,arr,k)){
                res=Math.min(res,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return res==Integer.MAX_VALUE ? maxi :res;
    }
    private boolean isPossible(int start,int[] arr,int k){
        int count=0;
        
        for(int i:arr){
            if(i%start!=0){
                count+=(i/start)+1;
            }else{
                count+=(i/start);
            }
            if(count>k) return false;
        }
        return true;
    }
}