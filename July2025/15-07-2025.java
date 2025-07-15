

// Divisible by 13
// Difficulty: MediumAccuracy: 50.24%Submissions: 16K+Points: 4
// Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.

class Solution {
    public boolean divby13(String s) {
        int mod = 0;
        for (int i = 0; i < s.length(); i++) {
            mod = (mod * 10 + (s.charAt(i) - '0')) % 13;
        }
        return mod == 0;
    }
}