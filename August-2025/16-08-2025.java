// Form the Largest Number
// Difficulty: MediumAccuracy: 37.82%Submissions: 175K+Points: 4
// Given an array of integers arr[] representing non-negative integers, arrange them so that after concatenating all of them in order, it results in the largest possible number. Since the result may be very large, return it as a string.


class Solution {
    public String findLargest(int[] arr) {
        // code here
        String [] str=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            str[i]=""+arr[i];
        }
        Arrays.sort(str,(a,b)->{
            String s=a+b;
            String m=b+a;
            return m.compareTo(s);
        });
        StringBuilder sb=new StringBuilder();
        for(String item:str) sb.append(item);
         boolean flag=true;
         for(int i=0;i<sb.length();i++){
             char ch=sb.charAt(i);
             if(ch!='0'){
                 flag=false;
                 break;
             }
         }
         if(flag==true) return "0";
        return sb.toString();
    }
}