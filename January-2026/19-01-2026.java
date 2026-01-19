// Remove K Digits
// Difficulty: MediumAccuracy: 26.8%Submissions: 78K+Points: 4
// Given a non-negative integer s represented as a string and an integer k, remove exactly k digits from the string so that the resulting number is the smallest possible, while maintaining the relative order of the remaining digits.

// Note : The resulting number must not contain any leading zeros.
// If the resulting number is an empty string after the removal, return "0".


class Solution {
    public String removeKdig(String S, int k) {
        int n = S.length();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = S.charAt(i);

            while (!s.isEmpty() && k > 0 && ch < s.peek()) {
                s.pop();
                k--;
            }

            if (!s.isEmpty() || ch != '0') {
                s.push(ch);
            }
        }

        while (!s.isEmpty() && k > 0) {
            s.pop();
            k--;
        }

        if (s.isEmpty()) return "0";

        StringBuilder str = new StringBuilder();
        while (!s.isEmpty()) {
            str.append(s.pop());
        }

        return str.reverse().toString();
    }
}