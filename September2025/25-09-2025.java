// Generate Binary Numbers
// Difficulty: EasyAccuracy: 67.48%Submissions: 55K+Points: 2
// Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

// Examples:

class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String>  res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            res.add(Integer.toBinaryString(i));
        }
        
        return res;
    }
}