// Lexicographically smallest after removing k
// Difficulty: MediumAccuracy: 49.97%Submissions: 28K+Points: 4
// Given a string s consisting of n lowercase characters. Return the lexicographically smallest string after removing exactly k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k characters.

// Note: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.


class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
            int n=s.length();
            if((n&(n-1))==0) k/=2;
            else k*=2;
            if(k>=n) return "-1";
            StringBuilder st = new StringBuilder();
            int remove =k;
            for(char ch : s.toCharArray()){
                while(st.length()>0 && remove >0 && st.charAt(st.length()-1)>ch){
                    st.deleteCharAt(st.length()-1);
                    remove--;
                }
                st.append(ch);
            }
            
            while(remove > 0){
                st.deleteCharAt(st.length()-1);
                remove--;
            }
            return st.length() ==0 ? "-1" : st.toString();
    }
}