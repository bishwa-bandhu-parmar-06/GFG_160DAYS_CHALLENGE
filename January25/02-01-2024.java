//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//import java.util.HashMap;

class Solution {
    public int countSubarrays(int[] arr, int k) {
        // HashMap to store prefix sums and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initial values
        map.put(0, 1); // To handle subarrays equal to k starting from index 0
        int prefixSum = 0;
        int count = 0;

        // Traverse the array
        for (int num : arr) {
            prefixSum += num; // Update the prefix sum

            // Check if (prefixSum - k) exists in the map
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k); // Add the frequency of (prefixSum - k)
            }

            // Update the frequency of the current prefixSum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count; // Return the total count of subarrays
    }
}
