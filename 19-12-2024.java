// Kth Missing Positive Number in a Sorted Array
// Difficulty: Medium    Accuracy: 53.02%         Submissions: 18K+         Points: 4
// Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

class Solution {
    public int kthMissing(int[] arr, int k) {
        int n=arr.length;
        int s=1,e=arr[n-1];
        int[] temp=new int[k];
        int t=0;
        for(int i=0;i<n;i++){
            while(s<arr[i] && t<k){
                
                temp[t++]=s;
                s++;
            }
            if(t==k) break;
            else {
                s=arr[i]+1;
            }
        }
        while(t<k){
            temp[t++]=s;
            s++;
        }
        return temp[k-1];
        
    }
}