// Find the closest pair from two arrays
// Difficulty: EasyAccuracy: 18.01%Submissions: 70K+Points: 2
// Given two sorted arrays arr1[] and arr2[] of size n and m and a number x, find the pair whose sum is closest to x and the pair has an element from each array. In the case of multiple closest pairs return any one of them.

// Note : In the driver code, the absolute difference between the sum of the closest pair and x is printed.



class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        
        int i = n - 1; // tracking arr1
        int j = 0; // tracking arr2
        int prevDiff = Integer.MAX_VALUE;
        int val1 = -1;
        int val2 = -1;
        while((i >= 0) && (j < m)){
            if(Math.abs((arr1[i] + arr2[j]) - x) <= prevDiff){
                val1 = arr1[i];
                val2 = arr2[j];
                prevDiff = Math.abs((val1 + val2) - x);
            }

            if((arr1[i] + arr2[j]) <= x){
                j++;
            }else{
                i--;
            }
        }
        
        ArrayList<Integer> ansList = new ArrayList<>();
        ansList.add(val1);
        ansList.add(val2);
        
        return ansList;
    }
}