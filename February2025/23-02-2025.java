// Next Greater Element
// Difficulty: MediumAccuracy: 32.95%Submissions: 436K+Points: 4Average Time: 20m
// Given an array arr[ ] of integers, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements from stack that are smaller than current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is not empty, the top is the next greater element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push current element onto the stack
            stack.push(arr[i]);
        }

        return result;
    }
}
