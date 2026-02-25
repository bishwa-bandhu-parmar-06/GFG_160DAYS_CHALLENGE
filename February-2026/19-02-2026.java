// Missing Element in Range
// Difficulty: MediumAccuracy: 55.45%Submissions: 11K+Points: 4Average Time: 20m
// Given an array arr[] of integers and a range [low, high], find all the numbers within the range that are not present in the array. return the missing numbers in sorted order.


class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i : arr) set.add(i);
        
        for(int i=low;i<=high;i++){
            if(set.contains(i)==false) ans.add(i);
        }
        
        return ans;
    }
}