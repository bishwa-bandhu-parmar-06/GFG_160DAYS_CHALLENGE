// Non-overlapping Intervals
// Difficulty: Medium        Accuracy: 51.92%      Submissions: 21K+      Points: 4
// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.


class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals , (a,b)->a[1]-b[1]);
        int end = intervals[0][1] , count =1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                count++;
                end = intervals[i][1];
            }
        }
        
        return intervals.length-count;
    }
}