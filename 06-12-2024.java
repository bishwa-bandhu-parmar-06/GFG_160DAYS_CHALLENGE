
// Find H-Index
// Difficulty: Medium        Accuracy: 53.4%      Submissions: 12K+      Points: 4
// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.

// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);
        int H = 0;
        ;

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                H++;
            }

        }

        return H;
    }
}