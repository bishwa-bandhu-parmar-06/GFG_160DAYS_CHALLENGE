// Look and Say Pattern
// Difficulty: MediumAccuracy: 62.54%Submissions: 39K+Points: 4
// Given an integer n. Return the nth row of the following look-and-say pattern.
// 1
// 11
// 21
// 1211
// 111221
// Look-and-Say Pattern:

// To generate a member of the sequence from the previous member, read off the digits of the previous member, counting the number of digits in groups of the same digit. For example:

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// 1211 is read off as "one 1, one 2, then two 1s" or 111221.
// 111221 is read off as "three 1s, two 2s, then one 1" or 312211.

class Solution {
    public String countAndSay(int n) {
        // code here
        if (n <= 0) return "";
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;

            // Read the previous result and generate the next
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    current.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last counted group
            current.append(count).append(result.charAt(result.length() - 1));
            result = current.toString();
        }

        return result;
    }
}