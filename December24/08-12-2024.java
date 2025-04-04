// Overlapping Intervals
// Difficulty: Medium    Accuracy: 57.41%        Submissions: 82K+      Points: 4
// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (x,y)->x[0]-y[0]);
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        
        while(i < n){
            int end = arr[i][1];
            j = i+1;
            while(j < n && arr[j][0] <= end){
                end = Math.max(end, arr[j][1]);
                j++;
            }
            ans.add(new int[]{arr[i][0], end});
            i = j;
        }
        return ans;
    }
}
