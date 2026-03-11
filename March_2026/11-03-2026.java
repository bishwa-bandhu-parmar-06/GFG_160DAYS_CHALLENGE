// Sum of subarray minimums
// Difficulty: MediumAccuracy: 46.92%Submissions: 30K+Points: 4Average Time: 30m
// Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.

// Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.


class Solution {

    public int sumSubMins(int[] arr) {

    int n=arr.length;

    int[]left=new int[n],right=new int[n];

    Deque<Integer>st=new ArrayDeque<>();

    for(int i=0;i<n;i++){

        while(!st.isEmpty()&&arr[st.peek()]>arr[i])

        st.pop();

    left[i]=st.isEmpty()?i+1:i-st.peek();

    st.push(i);

    }

    st.clear();

 for(int i=n-1;i>=0;i--){

     while(!st.isEmpty()&&arr[st.peek()]>=arr[i])

     st.pop();

     right[i]=st.isEmpty()?n-i:st.peek()-i;

     st.push(i);

 }

   long ans=0; 

   for(int i=0;i<n;i++){

       ans+=(long)arr[i]*left[i]*right[i];

   }

   return (int)ans;

    }

}

