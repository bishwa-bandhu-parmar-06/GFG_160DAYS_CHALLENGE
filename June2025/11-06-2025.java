// Remove the balls
// Difficulty: MediumAccuracy: 58.66%Submissions: 38K+Points: 4
// You are given two arrays, color and radius, representing a sequence of balls:


// color[i] is the color of the i-th ball.
// radius[i] is the radius of the i-th ball.

// If two consecutive balls have the same color and radius, remove them both. Repeat this process until no more such pairs exist.


// Return the number of balls remaining after all possible removals.


class Solution {
    public int findLength(int[] color, int[] radius) {
       
       Stack<int[]> s=new Stack<>();
       
       for(int i=0;i<color.length;i++){
           if(!s.isEmpty()){
               int[] p=s.peek();
               if(p[0]==color[i] && p[1]==radius[i]){
                   s.pop();
               }else{
                   s.push(new int[] {color[i],radius[i]});
               }
           }else{
               s.push(new int[] {color[i],radius[i]});
           }
       }
       return s.size();
    }
}