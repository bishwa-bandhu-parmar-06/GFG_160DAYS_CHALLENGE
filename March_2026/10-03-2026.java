// Subarrays with First Element Minimum
// Difficulty: MediumAccuracy: 56.75%Submissions: 12K+Points: 4
// You are given an integer array arr[ ]. Your task is to count the number of subarrays where the first element is the minimum element of that subarray.

// Note: A subarray is valid if its first element is not greater than any other element in that subarray.


class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int ans=0,n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            int last=st.isEmpty()==true?n:st.peek();
            ans+=(last-i);
            st.push(i);
        }
        return ans;
    }
}