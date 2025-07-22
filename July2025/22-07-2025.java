
// Smallest Positive Missing
// Difficulty: MediumAccuracy: 25.13%Submissions: 436K+Points: 4
// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

// Note: Positive number starts from 1. The array can have negative integers too./

class Solution {
    public int missingNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
       int i=1;
        for(int val : arr){
            set.add(val);
        }
       while(!set.isEmpty()){
           if(!set.contains(i)){
               return i;
           }
           i++;
       }
        return -1;
    }
}


