// Find H-Index
// Difficulty: MediumAccuracy: 53.4%Submissions: 44K+Points: 4
// You are given an array citations[], where each element citations[i] represents the number of citations received by the ith paper of a researcher. You have to calculate the researcher’s H-index.
// The H-index is defined as the maximum value H, such that the researcher has published at least H papers, and all those papers have citation value greater than or equal to H.


class Solution {
    public int hIndex(int[] arr) {
        // code here
        int res[]=new int[arr.length+1];
        for(int x:arr)
        {
            if(x>=arr.length)
            {
                res[arr.length]++;
            }
            else
            res[x]++;
        }
        int s[]=new int[arr.length+1];
        s[arr.length]=res[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            s[i]=res[i]+s[i+1];
        }
        for(int i=arr.length;i>=0;i--)
        {
            if(s[i]>=i)
            return i;
        }
        return 0;
    }
}