// Pythagorean Triplet
// Difficulty: MediumAccuracy: 24.77%Submissions: 235K+Points: 4Average Time: 20m
// Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.


class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        
        Set<Integer> set = new HashSet<>();
        for(int val : arr) {
            set.add(val);
        }
        
        for (int i = 0 ; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                
                int a = arr[i];
                int b = arr[j];
                int c = (int)Math.sqrt(a * a + b * b);
                
                if (c*c == a*a + b*b && set.contains(c)){
                    return true;
                }
            }
        }
        return false;