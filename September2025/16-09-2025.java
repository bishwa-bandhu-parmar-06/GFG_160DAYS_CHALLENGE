// Postfix Evaluation
// Difficulty: MediumAccuracy: 63.04%Submissions: 120K+Points: 4
// You are given an array of strings arr[] that represents a valid arithmetic expression written in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an integer representing its value.

// Note: A postfix expression is of the form operand1 operand2 operator (e.g., "a b +"). 
// And the division operation between two integers always computes the floor value, i.e floor(5 / 3) = 1 and floor(-5 / 3) = -2.
// It is guaranteed that the result of the expression and all intermediate calculations will fit in a 32-bit signed integer.

class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
        Stack<Integer> stack=new Stack<>();
        for(String i:arr){
            if(i.equals("+") ||i.equals("-") || i.equals("*") || i.equals("/") || i.equals("^")){
                if(i.equals("+")){
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push(a+b);
                }
                else if(i.equals("-")){
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push(a-b);
                }
                else if(i.equals("*")){
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push(a*b);
                }
                else if(i.equals("/")){
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push(Math.floorDiv(a,b));
                }
                else {
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push((int)Math.pow(a,b));
                }
            }
            else{
                int temp=Integer.parseInt(i);
                stack.push(temp);
            }
        }
        return(stack.pop());
    }
}