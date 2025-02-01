
// Non Repeating Character
// Difficulty: Easy      Accuracy: 40.43%       Submissions: 244K+       Points: 2
// Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
// Note: When you return '$' driver code will output -1.







class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        Map<Character, Integer> map = new LinkedHashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char key : map.keySet()){
            if(map.get(key) == 1)return key;
        }
        
        return '$';
        
    }
}