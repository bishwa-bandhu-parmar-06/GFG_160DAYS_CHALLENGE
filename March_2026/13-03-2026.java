// Generate IP Addresses
// Difficulty: MediumAccuracy: 38.71%Submissions: 51K+Points: 4Average Time: 30m
// Given a string s containing only digits, your task is to restore it by returning all possible valid IP address combinations. You can return your answer in any order.

// A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255(inclusive).

// Note: The numbers cannot be 0 prefixed unless they are 0. For example, 1.1.2.11 and 0.11.21.1 are valid IP addresses while 01.1.2.11 and 00.11.21.1 are not.
// If there are no possible valid IP address return an empty list. The driver code will print -1 in this case.


class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, ArrayList<String> parts, ArrayList<String> result) {
        if (parts.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        int remaining = 4 - parts.size();
        int charsLeft = s.length() - start;

        if (charsLeft < remaining || charsLeft > remaining * 3) return;

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            if (len > 1 && segment.charAt(0) == '0') break;
            if (Integer.parseInt(segment) > 255) break;

            parts.add(segment);
            backtrack(s, start + len, parts, result);
            parts.remove(parts.size() - 1);
        }
    }
}