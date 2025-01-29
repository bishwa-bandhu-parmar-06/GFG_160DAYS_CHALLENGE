// Implement Pow
// Difficulty: Medium     Accuracy: 52.79%       Submissions: 19K+         Points: 4
// Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class 29-01-2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        return Math.pow(b, e);
    }
}


//{ Driver Code Starts.
// } Driver Code Ends