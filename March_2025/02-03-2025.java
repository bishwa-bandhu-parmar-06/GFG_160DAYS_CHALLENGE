// K Sized Subarray Maximum
// Difficulty: MediumAccuracy: 26.04%Submissions: 374K+Points: 4
// Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.


class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) dq.pollLast();
            dq.addLast(i);
            if(i>=k-1) al.add(arr[dq.peekFirst()]);
        }
        return al;
    }
}
