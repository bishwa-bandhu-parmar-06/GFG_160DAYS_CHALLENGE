// Number of Valid Parentheses
// Difficulty: MediumAccuracy: 76.44%Submissions: 1K+Points: 4Average Time: 30m
// You are given a number n, your task is to find the number of all the valid parentheses expressions of that length using only "(" and ")" brackets.

// An input string of parentheses is valid if :

// Open brackets must be closed in correct order.
// Every close bracket has a corresp
// 
// onding open bracket.
// For example - "()()" or "(())" are valid while ")()(" or "))((" are invalid parentheses expressions.



class Solution {
    int findWays(int n) {
        // code here
        ArrayList<String>ans=new ArrayList<>();
        String s="";
        if(n%2!=0) return 0;
        helper(n/2,n/2,ans,s);
        return ans.size();
    }
    public void helper(int open,int close,ArrayList<String>ans,String s){
        if(open==0 && close==0){
            if(!ans.contains(s))   ans.add(s);
        }
        if(open>0){
            helper(open-1,close,ans,s+"(");
        }
        if(close>open){
            helper(open,close-1,ans,s+")");
        }
        
    }
    
}