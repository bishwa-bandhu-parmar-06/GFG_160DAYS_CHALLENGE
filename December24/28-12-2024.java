// Find All Triplets with Zero Sum
// Difficulty: MediumAccuracy: 50.36%Submissions: 46K+Points: 4
// Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
// Returned triplet should also be internally sorted i.e. i<j<k.



//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                int target = -arr[i]-arr[j];
                if(map.containsKey(target)) {
                    for(int num: map.get(target)) {
                        if(num>j) {
                            List<Integer> temp = Arrays.asList(i, j, num);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans;
        
    }   
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends