// Next Greater Element in Circular Array
// Difficulty: MediumAccuracy: 56.97%Submissions: 62K+Points: 4
// Given a circular integer array arr[], the task is to determine the next greater element (NGE) for each element in the array.

// The next greater element of an element arr[i] is the first element that is greater than arr[i] when traversing circularly. If no such element exists, return -1 for that position.

// Note: Since the array is circular, after reaching the last element, the search continues from the beginning until we have looked at all elements once.


class Solution {
 public ArrayList<Integer> nextGreater(int[] arr) {  
   
        if (arr == null || arr.length == 0) return new ArrayList<>();

        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>(); 

       
        for (int i = 0; i < 2 * n; i++) {
            int val = arr[i % n];

            while (!stack.isEmpty() && arr[stack.peek()] < val) {
                res[stack.pop()] = val;
            }

            
            if (i < n) stack.push(i);
        }

        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int x : res) ans.add(x);
        return ans;
    

    }
}

