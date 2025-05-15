// Substrings with same first and last characters
// Difficulty: EasyAccuracy: 50.0%Submissions: 22K+Points: 2
// Given a string s consisting of lowercase characters, the task is to find the count of all substrings that start and end with the same character.


public int countSubstring(String s) {
    // code here
     int subString = 0;
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
        int j = s.charAt(i) - 97;
        subString += 1 + freq[j];
        freq[j]++;
    }
    return subString;
}