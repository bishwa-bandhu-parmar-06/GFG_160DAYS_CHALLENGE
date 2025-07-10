// Find the longest string
// Difficulty: MediumAccuracy: 56.04%Submissions: 32K+Points: 4
// Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present in the array words[]. 

// Note: If multiple strings have the same maximum length, return the lexicographically smallest one.


class Solution {
    public String longestString(String[] words) {
        // code here
        
         Arrays.sort(words); 
        Set<String> st=new HashSet<>();
        String ans="";
        
        for(String word:words)
        {
            if(word.length()==1 || st.contains(word.substring(0,word.length()-1)))
            {
                st.add(word);
                
                if(word.length()>ans.length() ||
               word.length()==ans.length() && word.compareTo(ans)<0)
                {
                    ans=word;
                }
            }
            
        }
        
        return ans;
    }
    

}