// Next Greater Element in Circular Array
// Difficulty: MediumAccuracy: 56.97%Submissions: 49K+Points: 4
// Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.

// The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly. If no such element exists, return -1 for that position.

// Circular Property:

// Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.



class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int i = (2 * n) - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i % n]) {
                st.pop();
            }
            if(i < n) {
                if(st.isEmpty()) {
                    res.add(-1);
                } else {
                    res.add(st.peek());
                }
            }
            st.push(arr[i % n]);
        }
        Collections.reverse(res);
        return res;
    }
}