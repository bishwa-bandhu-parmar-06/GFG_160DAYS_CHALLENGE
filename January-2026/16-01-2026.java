// Minimum Number of Workers
// Difficulty: MediumAccuracy: 59.11%Submissions: 9K+Points: 4
// You are given an array arr[], where arr[i] denotes the range of working hours a person at position i can cover.

// If arr[i] ≠ -1, the person at index i can work and cover the time interval [i - arr[i], i + arr[i]].
// If arr[i] = -1, the person is unavailable and cannot cover any time.
// The task is to find the minimum number of people required to cover the entire working day from 0 to n - 1. If it is not possible to fully cover the day, return -1.



class Solution {
    public int minMen(int arr[]) {
      
      int n = arr.length;
      
      int maxReach[] = new int [n];
      
      Arrays.fill(maxReach, -1);
      
      for(int i = 0; i< arr.length; i++)
      {
          if(arr[i] != -1)
          {
              int left = Math.max(0, i - arr[i]);
              int right = Math.min(n-1, i + arr[i]);
              
              maxReach[left] = Math.max(maxReach[left], right);
          }
      }
      
      
      if(maxReach[0] == -1)
      {
          return -1;
      }
      
      int currEnd = 0;
      int farthest = 0;
      int i = 0;
      int people = 0;
      
      while(currEnd < n)
      {
          while( i<= currEnd && i < n) {
              
              farthest = Math.max(farthest, maxReach[i]);
              i++;
          }
          
          if(farthest < currEnd) return -1;
          people++;
          currEnd = farthest + 1;
      }
      return people;
        
    }
}