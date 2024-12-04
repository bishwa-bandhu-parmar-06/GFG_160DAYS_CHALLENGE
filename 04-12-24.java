// Strings Rotations of Each Other
// Difficulty: Easy         Accuracy: 43.83%        Submissions: 205K+          Points: 2
// You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

// Note: The characters in the strings are in lowercase.


class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        int n = s1.length(), m = s2.length();
        if(n != m) return false;
        
        String concatenated = s1 + s1;

        return KMP(concatenated, s2);
    }
    
    static boolean KMP(String str1, String str2){
        int n = str1.length(), m = str2.length();
        int fir = 0, sec = 0;
        int[] lps = findlps(str2);
        
        while(fir < n){
            if(str1.charAt(fir) == str2.charAt(sec)){
                fir++;
                sec++;
                
                if(sec == m) return true;
            }
            else{
                if (sec != 0) sec = lps[sec - 1];
                else fir++;
            }
        }
        
        return false;
    }
    
    static int[] findlps(String str){
        int n = str.length();
        int pref = 0, suff = 1;
        int[] lps = new int[n];
        
        while(suff < n){
            if(str.charAt(pref) == str.charAt(suff)){
                lps[suff] = pref+1;
                pref++;
                suff++;
            }
            else{
                if(pref == 0) lps[suff++] = 0;
                else pref = lps[pref-1];
            }
        }
        
        return lps;
    }
}