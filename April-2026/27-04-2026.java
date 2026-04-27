// Smallest window containing 0, 1 and 2
// Difficulty: EasyAccuracy: 49.73%Submissions: 64K+Points: 2
// Given a string s consisting only of the characters '0', '1' and '2', determine the length of the smallest substring that contains all three characters at least once.

// If no such substring exists, return -1.



class Solution {

    public int smallestSubstring(String s) {

    int zero=-1,one=-1,two=-1,ans=100001;

    for(int i=0;i<s.length();i++){

        if(s.charAt(i)=='0') zero=i;

        if(s.charAt(i)=='1') one=i;

        if(s.charAt(i)=='2') two=i;

        if(zero==-1||one==-1||two==-1) continue;

        int min=Math.min(Math.min(one,two),zero);

        int max=Math.max(Math.max(one,two),zero);

        ans=Math.min(ans,max-min+1);

    }

    return ans==100001?-1:ans;

    }

};