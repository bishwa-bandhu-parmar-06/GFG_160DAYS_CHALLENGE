// Subset XOR
// Difficulty: MediumAccuracy: 81.2%Submissions: 1K+Points: 4
// Given an positive integer n, find a subset of numbers from 1 to n (inclusive), where each number can be used at most once, such that:

// The XOR of all elements in the subset is exactly n.
// The size of the subset is as large as possible.
// If multiple such subsets exist, choose the lexicographically smallest one.
// Lexicographical Order : A subset A[] is lexicographically smaller than subset B[] if at the first index where they differ, A[i] < B[i] (based on character ASCII/Unicode values).
// If all elements match but one subset ends earlier, the shorter subset is considered smaller.



class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        // code here
        int xor=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            xor^=i;
            ans.add(i);
        }
        if(xor==n)return ans;
        else{
            int k=xor ^ n;
            ans.remove(Integer.valueOf(k));
            return ans;
        }
    }
}