// Pythagorean Triplet
// Difficulty: MediumAccuracy: 24.77%Submissions: 260K+Points: 4Average Time: 20m
// Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.


class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int a: arr) set.add(a*a);
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int curr = (arr[i]*arr[i]) + (arr[j]*arr[j]);
                if(set.contains(curr)) return true;
            }
        }
        return false ;
        
    }
}