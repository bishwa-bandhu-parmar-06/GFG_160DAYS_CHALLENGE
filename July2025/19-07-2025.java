// Count Unique Vowel Strings
// Difficulty: MediumAccuracy: 50.99%Submissions: 13K+Points: 4
// You are given a lowercase string s, determine the total number of distinct strings that can be formed using the following rules:

// Identify all unique vowels (a, e, i, o, u) present in the string.
// For each distinct vowel, choose exactly one of its occurrences from s. If a vowel appears multiple times, each occurrence represents a unique selection choice.
// Generate all possible permutations of the selected vowels. Each unique arrangement counts as a distinct string.
// Return the total number of such distinct strings.


class Solution {
    public int vowelCount(String s) {
        // code here
        int len=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        ArrayList<Character> list=new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(list.contains(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        if (map.isEmpty()) return 0;
        
        int n=map.size();
        int factorial=fact(n);
        
        int ans=1;
        for(int val:map.values()){
            ans*=val;
        }
        return ans*factorial;
    }
    public int fact(int n){
        int ans=1;
        for(int i=2;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
}