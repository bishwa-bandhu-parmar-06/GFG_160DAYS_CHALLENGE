// Difference Check
// Difficulty: MediumAccuracy: 69.46%Submissions: 7K+Points: 4
// Given an array arr[] of time strings in 24-hour clock format "HH:MM:SS", return the minimum difference in seconds between any two time strings in the arr[].
// // The clock wraps around at midnight, so the time difference between "23:59:59" and "00:00:00" is 1 second.\




class Solution {
    public int minDifference(String[] arr) {
        // code here
        Arrays.sort(arr) ;
        
        int less = Integer.MAX_VALUE ; 
        
        for(int i = 1 ; i < arr.length ; i++){
            int diff = hourToSecond(arr[i]) - hourToSecond(arr[i-1]) ; 
            less = Math.min(less , diff) ; 
        }
        
         int first = hourToSecond(arr[0]);
        int last = hourToSecond(arr[arr.length - 1]);
        int wrapAroundDiff = (24 * 3600 - last + first);
        less = Math.min(less, wrapAroundDiff);

        return less;
    }
    
    public int hourToSecond(String hour){
        String part[] = hour.split(":") ;
        
        int h = Integer.valueOf(part[0]) ; 
        int m = Integer.valueOf(part[1]) ; 
        int s = Integer.valueOf(part[2]) ; 
        
        return (h * 3600 + m * 60 + s) ;  
    } 
}