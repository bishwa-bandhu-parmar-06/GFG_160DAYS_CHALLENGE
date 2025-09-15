// String stack
// Difficulty: MediumAccuracy: 46.69%Submissions: 15K+Points: 4
// You are given two strings pat and tar consisting of lowercase English characters. You can construct a new string s by performing any one of the following operation for each character in pat:

// Append the character pat[i] to the string s.
// Delete the last character of s (if s is empty do nothing).
// After performing operations on every character of pat exactly once, your goal is to determine if it is possible to make the string s equal to string tar.

class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        if (tar.length() > pat.length()) return false;
        int i=pat.length()-1,j=tar.length()-1;
        while(i>=0 && j>=0){
            if(pat.charAt(i)==tar.charAt(j)){i--;j--;}
            else{i=i-2;}
        }
        if(j>=0){return false;}
        return true;
    }
}
