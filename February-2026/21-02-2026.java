// Find H-Index
// Difficulty: MediumAccuracy: 53.4%Submissions: 65K+Points: 4
// You are given an array citations[], where each element citations[i] represents the number of citations received by the ith paper of a researcher. You have to calculate the researcher’s H-index.
// The H-index is defined as the maximum value H, such that the researcher has published at least H papers, and all those papers have citation value greater than or equal to H.

class Solution {
    public int hIndex(int[] citations) {
                Arrays.sort(citations);
        
        
        int n =citations.length;
        
        for(int i=0;i<n;i++){
            int papers =n-i;
            if(citations [i]>=papers){
                return papers;
            }
        }
        
        return 0;
    }
} 