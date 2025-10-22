// Nearly sorted
// Difficulty: MediumAccuracy: 75.25%Submissions: 84K+Points: 4Average Time: 30m
// Given an array arr[], where each element is at most k positions away from its correct position in the sorted order.
// Your task is to restore the sorted order of arr[] by rearranging the elements in place.

// Note: Don't use any sort() method.


class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int index = 0;

        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            pq.add(arr[i]); 
        }

        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll(); 
            pq.add(arr[i]);           
        }

        
        while (!pq.isEmpty()) {        
            arr[index++] = pq.poll();
        }
        
    }
}