# Max Amount by Selling K Tickets
# Difficulty: MediumAccuracy: 40.68%Submissions: 8K+Points: 4
# Given an integer array arr[], where arr[i] denotes the number of tickets available with the i-th ticket seller.

# The price of each ticket is equal to the number of tickets remaining with that seller at the time of sale. 
# A seller can sell at most one ticket at a time, and after each sale, the price of the next ticket from that seller decreases by 1.
# All sellers are allowed to sell at most k tickets in total.
# Find the maximum amount that can be earned by selling k tickets. Return the answer modulo 109+7.

# Examples:




class Solution:
    def maxAmount(self, arr, k):
        pq = []
        mod = int(1e9)+7
        for ele in arr:
            heapq.heappush(pq,-ele)
        ans=0
        while k>0:
            ele = -heapq.heappop(pq)
            if ele<=0:
                return ans
            ans = (ans+ele)%mod
            heapq.heappush(pq,-(ele-1))
            k-=1
        return ans