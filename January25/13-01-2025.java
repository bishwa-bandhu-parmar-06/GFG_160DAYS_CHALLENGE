// Container With Most Water
// Difficulty: Medium        Accuracy: 53.84%       Submissions: 68K+        Points: 4
// Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

// Note: In the case of a single vertical line it will not be able to hold water.



class Solution {

    public int maxWater(int arr[]) {
       // Code Here
       int maxAmountWater = 0;
      
      int i=0;
      int j = arr.length-1;
      
      
      while(i<j){
          int diff = j-i;
          if(arr[i]<arr[j]){
              
              
              int prod = diff*arr[i];
              if(prod > maxAmountWater){
                  maxAmountWater = prod;
              }
              i++;
          }
          else {
              int prod = diff*arr[j];
              if(prod > maxAmountWater){
                  maxAmountWater = prod;
              }
              j--;
              
          }
      }
       return maxAmountWater;
   }


}