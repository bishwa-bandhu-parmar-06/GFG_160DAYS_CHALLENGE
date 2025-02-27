// Get Min from Stack
// Difficulty: MediumAccuracy: 22.59%Submissions: 264K+Points: 4Average Time: 30m
// Given q queries, You task is to implement the following four functions for a stack:

// push(x) – Insert an integer x onto the stack.
// pop() – Remove the top element from the stack.
// peek() - Return the top element from the stack. If the stack is empty, return -1.
// getMin() – Retrieve the minimum element from the stack in O(1) time. If the stack is empty, return -1.
// Each query can be one of the following:

// 1 x : Push x onto the stack.
// 2 : Pop the top element from the stack.
// 3: Return the top element from the stack. If the stack is empty, return -1.
// 4: Return the minimum element from the stack.

class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    // Returns the top element of the stack
    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    // Returns the minimum element in the stack
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
