// // Count distinct elements in every window
// Difficulty: Easy      Accuracy: 41.83%      Submissions: 141K+       Points: 2
// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new  ArrayList<Integer>();
        for(int i=0; i <= arr.length-k ; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i ; j<i+k ; j++){
                set.add(arr[j]);
            }
            res.add(set.size());
        
        }
        return res;
    }
}