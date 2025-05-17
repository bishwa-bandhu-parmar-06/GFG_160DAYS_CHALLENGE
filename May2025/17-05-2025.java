// Sort the given array after applying the given equation
// Difficulty: MediumAccuracy: 36.21%Submissions: 19K+Points: 4
// Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C. The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C. After applying this transformation to every element, return the modified array in sorted order.


class Solution {
    
    public int compute(int x, int A, int B, int C){
        return A*x*x + B*x + C;
    }
    
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        int[] sortedArr = new int[n];
        int i = 0, j = n-1;
        int index = A > 0 ? n-1 : 0;
        
        while(i<=j){
            int f1 = compute(arr[i], A, B, C);
            int f2 = compute(arr[j], A, B, C);
            if(A > 0){
               if(f1 > f2){
                   sortedArr[index--] = f1;
                   i++;
               }
               else {
                   sortedArr[index--] = f2;
                   j--;
               }
            }
            else {
               if(f1 < f2){
                   sortedArr[index++] = f1;
                   i++;
               }
               else {
                   sortedArr[index++] = f2;
                   j--;
               } 
            }
        }
        for(int a: sortedArr){
            sorted.add(a);
        }
        return sorted;
    }
}