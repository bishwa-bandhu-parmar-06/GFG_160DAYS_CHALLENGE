// Palindrome SubStrings
// Difficulty: HardAccuracy: 45.8%Submissions: 52K+Points: 8Average Time: 30m
// Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.

// Note: A substring is palindromic if it reads the same forwards and backwards.










class Solution {
    public int countPS(String s) {
        // code here
        int n = s.length();
        int count = 0;
        for(int i =0;i<n;i++){
            int forw = i+1;
            int back = i-1;
            
            while(back>=0  && forw <n){
                if(s.charAt(forw) == s.charAt(back)){
                    count++;
                     forw++; back--;
                }
                else break;
            }
            forw = i+1;
            back =i;
            while(back>=0  && forw <n){
                     if(s.charAt(forw) == s.charAt(back)){
                    count++;
                     forw++; back--;
                }
                else break;
            }
        }
        
        return count;
    }
}