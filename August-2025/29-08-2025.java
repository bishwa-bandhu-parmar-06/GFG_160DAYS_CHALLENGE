


// Smallest window containing all characters
// Difficulty: HardAccuracy: 30.19%Submissions: 179K+Points: 8Average Time: 30m
// Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p. Return empty string in case no such substring is present.
// If there are multiple such substring of the same length found, return the one with the least starting index.














class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s1, String s2) {
        
        // a variant of the problem smallest substring containing distinct character of the string itself
        
        StringBuilder ans=new StringBuilder();
        
        int n=s1.length();
        int m=s2.length();
        
        if(s2.length()>s1.length()){
            return ans.toString();
        }
        
        HashMap<Character,Integer> window=new HashMap<>();
        HashMap<Character,Integer> hms2=new HashMap<>();
        
        for(char c : s2.toCharArray()){
            hms2.put(c , hms2.getOrDefault(c,0)+1);
        }
        
        HashMap<Character,Integer> required=new HashMap<>(hms2);

         //window  include all character distinct
        for(char c : required.keySet()){
             window.put(c,0);
        }
        
        int start=-1;
        int min=Integer.MAX_VALUE;
        int i=0;//left 
        int j=0;//right
        int count=0; //required character
        
        while(j<n){
            
            char c=s1.charAt(j);
            
            if(required.containsKey(c)){
                window.put(c,window.get(c)+1);
                ///mindful of duplicates
                if(window.get(c)<=required.get(c)){
                    count++;
                }
            }
            
            while(count==m){
                
                if(j-i+1<min){
                    min=j-i+1;
                    start=i;
                }
                //shrinking from left
                char ch=s1.charAt(i);
                if(required.containsKey(ch)){
                    window.put(ch,window.get(ch)-1);
                    if(window.get(ch)<required.get(ch)){
                        count--;
                    }
                }
                i++;
            }
            j++;
        }
        if (start==-1){
            return "";
        }
        return s1.substring(start,start+min);
        
        
        
    }
}

