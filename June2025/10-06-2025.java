// Exactly one swap
// Difficulty: MediumAccuracy: 48.42%Submissions: 23K+Points: 4
// Given a string s, return the number of distinct strings that can be obtained by exactly one swap of two different indices (i < j).


class Solution {
    int countStrings(String s) {
        // code here
        
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
          char ch=s.charAt(i);
          map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=0;
        if(map.size()==n) count=0;
        else count=1;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int possible=n-(i+1);
            count+=possible;
            int fi=map.get(ch);
            map.put(ch,map.get(ch)-1);
            if(fi==1) continue;
            count-=map.get(ch);
            
        }
        
        return count;
    }
}