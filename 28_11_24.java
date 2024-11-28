// Implement Atoi
// Difficulty: Medium       Accuracy: 32.58%       Submissions: 226K+     Points: 4
// Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

// Cases for atoi() conversion:

// Skip any leading whitespaces.
// Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
// Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
// If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.


class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        boolean neg = false;
        int i=0;
        if(s.charAt(0) == '-'){
            neg = true;
            i=1;
        }
        
        long res = 0;
        
        for(;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return neg ? (int)(res)*-1 : (int)res;
            }
            
            res = res*10+(s.charAt(i)-'0');
        }
        if(neg && res*-1 < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        return neg ? (int)(res)*-1 : (int)res;
        
    }
}