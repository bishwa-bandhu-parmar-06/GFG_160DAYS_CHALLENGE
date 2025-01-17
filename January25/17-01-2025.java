// Product array puzzle
// Difficulty: EasyAccuracy: 33.46%Submissions: 267K+Points: 2
// Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.


class Solution {
    public static int[] productExceptSelf(int arr[]) 
    {
        int p=1;
        int c=0;
        for(int i:arr){
            if(i!=0) p*=i;
            else c++;
        }
        int res[]=new int[arr.length];
        if(c>=2) return res;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && c==0) res[i]=p/arr[i];
            else if(arr[i]!=0 && c>0) res[i]=0;
            else res[i]=p;
        }
        return res;
    }
}