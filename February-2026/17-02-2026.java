// Maximum number of overlapping Intervals
// Difficulty: HardAccuracy: 47.21%Submissions: 10K+Points: 8
// You are given an array of intervals arr[][], where each interval is represented by two integers [start, end] (inclusive). Return the maximum number of intervals that overlap at any point in time.




class Solution {
    
    public static int overlapInt(int[][] arr) {
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int []i : arr) {
            low = Math.min(low, i[0]);
            high = Math.max(high, i[1] + 1);
        }
        
        int []diff = new int[high+1];
        
        for(int []i : arr) {
            diff[i[0]]++;
            diff[i[1] + 1]--;
        }
        
        int result = 0;
        for(int i = low; i < high; i++) {
            diff[i] += diff[i-1];
            result = Math.max(result, diff[i]);
        }
        
        return result;
    }
}