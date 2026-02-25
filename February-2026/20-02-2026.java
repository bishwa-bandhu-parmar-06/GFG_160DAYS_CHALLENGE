// Form the Largest Number
// Difficulty: MediumAccuracy: 37.82%Submissions: 197K+Points: 4
// Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of them in order, it results in the largest possible number. Since the result may be very large, return it as a string.


class Solution {
    public String findLargest(int[] arr) 
    {
        // code here
        String s[]= new String[arr.length];
        int x=0;
        StringBuilder ans= new StringBuilder();
        for(int n:arr)
        {
            s[x++]=String.valueOf(n);
        }
        
        if(s[0].equals("0"))
            return "0"; //when all inputs are 0
        
        Arrays.sort(s, (a,b) -> (b+a).compareTo(a+b));
        
        for(String ss:s)
        {
            ans.append(ss);
        }
        
        return ans.toString();
    }
}

