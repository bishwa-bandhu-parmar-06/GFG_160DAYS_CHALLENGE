// K closest elements
// Difficulty: MediumAccuracy: 15.96%Submissions: 83K+Points: 4
// You are given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly k elements from the array closest to x, excluding x if it exists.

// An element a is closer to x than b if:


// |a - x| < |b - x|, or
// |a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)


// Return the k closest elements in order of closeness.


class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
     PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]
);

      int n=arr.length;
      for(int i=0;i<n;i++){
          if(arr[i]!=x){
              pq.add(new int[]{Math.abs(arr[i]-x),arr[i]});
          }
      }
      
      int[] ans=new int[k];
      int index=0;
      while(!pq.isEmpty() && k>0){
          int[] curr=pq.poll();
          ans[index]=curr[1];
          index++;
          k--;
      }
    
      return ans;
    }
}