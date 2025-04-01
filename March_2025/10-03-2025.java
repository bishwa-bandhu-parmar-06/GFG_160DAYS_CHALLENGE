//Edit Distance
//Difficulty: HardAccuracy: 35.14%Submissions: 228K+Points: 8
//Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
//The possible operations are permitted:

//Insert a character at any position of the string.
//Remove any character from the string.
//Replace any character from the string with any other character.



class Solution {
    public int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] d: dp) Arrays.fill(d, -1);
        return func(n-1, m-1, s1, s2, dp);
    }
    
    int func(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return func(i-1, j-1, s1, s2, dp);
        return dp[i][j] = 1 + Math.min(func(i, j-1, s1, s2, dp), Math.min(func(i-1, j, s1, s2, dp), func(i-1, j-1, s1, s2, dp)));
    }
}
