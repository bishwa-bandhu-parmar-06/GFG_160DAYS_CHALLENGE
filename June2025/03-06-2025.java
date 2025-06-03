// Substrings with K Distinct
// Difficulty: MediumAccuracy: 20.46%Submissions: 160K+Points: 4Average Time: 20m
// Given a string consisting of lowercase characters and an integer k, the task is to count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

// Examples :


class Solution {
    int countSubstr(String s, int k) {
        return countAtMost(s,k) - countAtMost(s,k-1);
    }
    int countAtMost(String s, int k){
        int l=0,count=0;
        HashMap<Character,Integer>map = new HashMap<>();
        for(int r=0; r<s.length(); r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size() > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                map.remove(s.charAt(l),0);
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }
}