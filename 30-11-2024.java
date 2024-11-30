// Anagram
// Difficulty: Easy      Accuracy: 44.93%     Submissions: 354K+     Points: 2
// Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

// Note: You can assume both the strings s1 & s2 are non-empty.

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // Your code here
        int l1=s1.length();
        int l2=s2.length();
        if(l1!=l2) return false;
        int[] arr = new int[26];
        for(int i=0;i<l1;i++){
            arr[s1.charAt(i)-'a']++;
        }
        for(int j=0;j<l2;j++){
            if(arr[s2.charAt(j)-'a']<1)return false;
            arr[s2.charAt(j)-'a']--;
        }
        return true;
    }
}