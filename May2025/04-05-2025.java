// Smallest distinct window
// Difficulty: MediumAccuracy: 31.85%Submissions: 102K+Points: 4
// Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.


class Solution {
    public int findSubString(String str) {
        Set<Character> st=new HashSet<>();
        for(char i:str.toCharArray())
        st.add(i);
        int cnt=Integer.MAX_VALUE;
        int r=0,l=0;
        Map<Character,Integer> map=new LinkedHashMap<>();
        while(r<str.length())
        {
            map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
            if(map.size()==st.size())
            {
                while(map.size()==st.size())
                {
                    cnt=Math.min(cnt,r-l+1);
                    map.put(str.charAt(l),map.get(str.charAt(l))-1);
                    if(map.get(str.charAt(l))==0)
                    map.remove(str.charAt(l));
                    l++;
                }
            }
            r++;
        }
        return cnt;
    }
}