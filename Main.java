// Longest Consecutive Subsequence
// Difficulty: Medium        Accuracy: 33.0%            Submissions: 328K+           Points: 4
// Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.


//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr);
        int currentlength=1;
        int maxlength=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]+1){
                currentlength++;
                
            }
            else if (arr[i]==arr[i-1])
               {
                    continue;
               }
               else{
                    maxlength=Math.max(maxlength,currentlength);
                    currentlength=1;
                }
                
                
            }
           maxlength=Math.max(maxlength,currentlength);
           return maxlength;
            
            
        
        
    }
}

