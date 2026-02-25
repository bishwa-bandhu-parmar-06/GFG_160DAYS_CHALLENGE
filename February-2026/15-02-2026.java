// Chocolate Distribution Problem
// Difficulty: EasyAccuracy: 49.91%Submissions: 269K+Points: 2Average Time: 15m
// Given an array arr[] of positive integers, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets among m students such that -
//       i. Each student gets exactly one packet.
//      ii. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum and return that minimum possible difference.



class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        
        int i = 0; int j = m-1;
        int n = arr.size();
        int ans = Integer.MAX_VALUE;
        
        while(j < n){
            ans = Math.min(ans, arr.get(j)-arr.get(i));
            i++; j++;
        }
        return ans;
    }
}