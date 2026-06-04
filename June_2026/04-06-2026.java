// Substring with Max Zero-One Diff
// Difficulty: MediumAccuracy: 53.05%Submissions: 46K+Points: 4
// Given a binary string s consisting of 0s and 1s. Find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in a substring of the string.

// Note: In the case of all 1s, the answer will be -1.

class Solution {
    int maxSubstring(String s) {
        int mx = -1, zc = 0, oc = 0, n = 0;
        
        for(char c : s.toCharArray()){
            
            if(c == '0'){
                zc++;
            }
            else{
                oc++;
                n++;
            }
        
            
            if(oc > zc){
                zc = 0;
                oc = 0;
            }
            
            mx = Math.max(zc - oc, mx);
            
        }
        
        return (n == s.length()) ? -1 : mx;
    }
}
