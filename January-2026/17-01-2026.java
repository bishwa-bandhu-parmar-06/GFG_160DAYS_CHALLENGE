// Expression contains redundant bracket or not
// Difficulty: MediumAccuracy: 48.71%Submissions: 39K+Points: 4
// Given a string of balanced expression s, check if it contains a redundant parenthesis or not. A set of parenthesis are redundant if the same sub-expression is surrounded by unnecessary or multiple brackets.
// Note: Expression may contain + , - , *, and / operators. Given expression is valid and there are no white spaces present.



class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        Stack<Character>stack= new Stack<>();
        
        int i=0;
        int n=s.length();
        while(i<n)
        {
            if(s.charAt(i)==')')
            {
                boolean operatorFound=false;
                if(!stack.isEmpty()&&stack.peek()=='(')
                return true;
                while(!stack.isEmpty()&&stack.peek()!='(')
                {
                    if(isOperator(stack.pop()))
                    operatorFound=true;
                }
                
                if(!operatorFound)
                return true;
                
                stack.pop();
            }
            else{
                stack.add(s.charAt(i));
            }
            i++;
        }
        
        if(stack.isEmpty()||containsValidCharacters(stack))
        return false;
        
        return true;
    }
    public static boolean isOperator(Character c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/')
        return true;
        
        return false;
    }
    public static  boolean containsValidCharacters(Stack<Character>stack)
    {
        for(Character c:stack)
        {
            if(c=='(')
            return false;
            
        }
        return true;
    }
}