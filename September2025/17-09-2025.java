// Decode the string
// Difficulty: MediumAccuracy: 44.28%Submissions: 67K+Points: 4Average Time: 10m
// Given an encoded string s, decode it by expanding the pattern k[substring], where the substring inside brackets is written k times. k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets. Return the final decoded string.

// Note: The test cases are generated so that the length of the output string will never exceed 105 .


class Solution {
    static String decodeString(String s) {
        // code here
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            
            switch(c)
            {
                case '[':
                    st.push(sb);
                    sb = new StringBuilder();
                    break;
                case ']':
                    decode(st, sb);
                    sb = st.pop();
                    break;
                
                default:
                    sb.append(c);
            }
            //System.out.println(st);
        }
        return sb.toString();
    }
    
    private static void decode(Stack<StringBuilder> st, StringBuilder sb)
    {
        StringBuilder num = st.size() > 0 ? st.pop() : null;
        
        if(num == null)
            return;
        
        String val = "";
        
        for(int i = num.length()-1; i>= 0; i--)
        {
            char c = num.charAt(i);
            
            if(isInteger(c))
            {
                val = c+val;
                num.setLength(num.length() - 1);
            }
            else
            {
                break;
            }
        }
        
        if(val.length() == 0)
        {
            st.push(num);
            return;
        }
        
        int freq = Integer.parseInt(val);
        
        StringBuilder decoded = getAppended(sb, freq-1);
        num.append(decoded);
        st.push(num);
    }
    
    private static StringBuilder getAppended(StringBuilder sb, int freq)
    {
        int len = sb.length();
        for(int i = 0; i<freq; i++)
        {
            sb.append(sb.substring(0, len));
        }
        return sb;
    }
    
    private static boolean isInteger(char c)
    {
        return c >= 48 && c <= 57;
    }
}