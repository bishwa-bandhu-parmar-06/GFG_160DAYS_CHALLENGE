// Stream First Non-repeating
// Difficulty: MediumAccuracy: 31.65%Submissions: 229K+Points: 4Average Time: 15m
// Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first non-repeating character in the prefix s[0..i]. If no such character exists, use '#'.



class Solution {
    public String firstNonRepeating(String s) {
        // code here
        int[] map = new int[26];
        Queue<Character> qt = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            map[ch - 'a']++;
            if(map[ch - 'a'] == 1) {
                qt.offer(ch);
            }
            else {
                while(!qt.isEmpty() && map[qt.peek() - 'a'] > 1)
                    qt.poll();
            }
            sb.append(qt.isEmpty() ? '#' : qt.peek());
        }
        return sb.toString(); 
    }
}