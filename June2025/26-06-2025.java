// Game with String
// Difficulty: MediumAccuracy: 53.96%Submissions: 59K+Points: 4Average Time: 15m
// Given a string s consisting of lowercase alphabets and an integer k, your task is to find the minimum possible value of the string after removing exactly k characters.

// The value of the string is defined as the sum of the squares of the frequencies of each distinct character present in the string.




class Solution {
    public int minValue(String s, int k) {
        // code here
        int freq [] = new int[26] ; 
        
        for(int c : s.toCharArray()){
            freq[c - 'a']++ ; 
        }
        
        while (k > 0) {
            Arrays.sort(freq);
            if (freq[25] == 0) break; 
            freq[25]--;
            k--;
        }
        
       int result = 0 ; 
       
       for(int i = 25 ; i >= 0 ; i-- ){
           if(freq[i] == 0 ) continue  ; 
           
           result += freq[i] * freq[i] ; 
       }
       
       return result; 
    }
}