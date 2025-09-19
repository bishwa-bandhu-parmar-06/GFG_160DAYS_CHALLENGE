// Min Add to Make Parentheses Valid
// Difficulty: MediumAccuracy: 64.41%Submissions: 9K+Points: 4
// You are given a string s consisting only of the characters '(' and ')'. Your task is to determine the minimum number of parentheses (either '(' or ')') that must be inserted at any positions to make the string s a valid parentheses string.

// A parentheses string is considered valid if:

// Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
// Every closing parenthesis ')' has a corresponding opening parenthesis '('.
// Parentheses are properly nested.


class Solution {
    public int minParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push(ch);
            } else {
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
}