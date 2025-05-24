// Sum of all substrings of a number
// Difficulty: MediumAccuracy: 38.11%Submissions: 63K+Points: 4
// Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.

// Note: The number may have leading zeros.
// It is guaranteed that the total sum will fit within a 32-bit signed integer.


class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int sum = 0;
        
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String num = s.substring(i,j+1);
                sum = sum + Integer.parseInt(num);
            }
        }
        
        return sum;
    }
}