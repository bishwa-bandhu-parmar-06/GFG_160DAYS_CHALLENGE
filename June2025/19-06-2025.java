// Case-specific Sorting of Strings
// Difficulty: MediumAccuracy: 69.88%Submissions: 64K+Points: 4Average Time: 45m
// Given a string s consisting of only uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

class Solution {
    public static String caseSort(String s) {
        // code here
        int []freq=new int[123];
            
                for(char ch:s.toCharArray()) {
                    freq[ch]++;
                }
                int cdx=65;
                int sdx=97;
                
                StringBuilder sb=new StringBuilder();
                
                    for(int i=0;i<s.length();i++) {
                        if(s.charAt(i)>='A'&&s.charAt(i)<='Z') {
                            for(; cdx<=90;cdx++) {
                                if(freq[cdx]>=1) {
                                    sb.append((char)cdx);
                                    freq[cdx]--;
                                    break;
                                }
                            }
                        }
                        else {
                            for(; sdx<=122;sdx++) {
                                if(freq[sdx]>=1) {
                                    sb.append((char)sdx);
                                    freq[sdx]--;
                                    break;
                                }
                            }
                        }
                    }
                    return sb.toString();
    }
}