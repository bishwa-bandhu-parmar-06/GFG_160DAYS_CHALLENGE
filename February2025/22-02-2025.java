// Longest valid Parentheses
// Difficulty: HardAccuracy: 26.13%Submissions: 139K+Points: 8Average Time: 20m
// Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

// A parenthesis string is valid if:

// For every opening parenthesis, there is a closing parenthesis.
// The closing parenthesis must be after its opening parenthesis.





class Solution {
    static int maxLength(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with -1 to handle edge cases

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Store the index of '('
            } else {
                stack.pop(); // Remove last '('
                if (stack.isEmpty()) {
                    stack.push(i); // Store the index of unmatched ')'
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
