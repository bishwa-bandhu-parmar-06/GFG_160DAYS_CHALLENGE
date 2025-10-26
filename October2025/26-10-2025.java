// Minimum Cost of ropes
// Difficulty: MediumAccuracy: 42.73%Submissions: 261K+Points: 4
// Given an array, arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost. The cost to connect two ropes is the sum of their lengths. 


class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num: arr){
            pq.add(num);
        }
        int ans=0;
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            pq.add(first+second);
            ans+=(first+second);
        }
        return ans;
    }
}