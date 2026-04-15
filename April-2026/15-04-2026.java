// URLify a given string
// Difficulty: BasicAccuracy: 77.86%Submissions: 5K+Points: 1
// Given a string s, replace all the spaces in the string with '%20'.

// Examples:

// Input: s = "i love programming"
// Output: "i%20love%20programming"
// Explanation: The 2 spaces are replaced by '%20'
// Input: s = "Mr Benedict Cumberbatch"
// Output: "Mr%20Benedict%20Cumberbatch"
// Explanation: The 2 spaces are replaced by '%20'
// Constraints:
// 1 ≤ s.size() ≤ 104


class Solution {
    String replaceSpaces(String s) {
        // code here
        String result = s.replaceAll("\\s", "%20");
        return result ;
        
    }
    
}