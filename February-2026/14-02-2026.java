// The Painter's Partition Problem-II
// Difficulty: HardAccuracy: 27.52%Submissions: 168K+Points: 8
// Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of painters available. Each painter takes 1 unit of time to paint 1 unit length of a board.

// Determine the minimum amount of time required to paint all the boards, under the constraint that each painter can paint only a contiguous sequence of boards (no skipping or splitting allowed).


class Solution {
    private int check(int md,int[] arr){
        int n = arr.length,sm=0,k=1;
        for(int i=0;i<n;i++){
            if(arr[i]>md)return Integer.MAX_VALUE;
            sm+=arr[i];
            if(sm>md){
                k++;
                sm=arr[i];
            }
        }
        return k;
    }
    public int minTime(int[] arr, int k) {
        int l=1,h=10000000,ans=-1;
        while(l<=h){
            int md = l + (h-l)/2;
            if(k>=check(md,arr)){
                ans=md;
                h=md-1;
            }else l=md+1;
        }
        return ans;
    }
}