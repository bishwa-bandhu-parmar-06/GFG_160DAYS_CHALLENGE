// Largest number in one swap
// Difficulty: EasyAccuracy: 32.65%Submissions: 5K+Points: 2
// Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.


class Solution {
    public String largestSwap(String s) {
        char maxVal = '0';
        int valIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= maxVal) {
                maxVal = c;
                valIdx = i;
            }
        }
        
        StringBuilder result = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i != valIdx && maxVal != c) {
                char d = result.charAt(i);
                result.setCharAt(i,maxVal);
                result.setCharAt(valIdx,d);
                break;
            }
        }
        
        
        return result.toString().compareTo(s) >=0 ?result.toString():s;
    }
}