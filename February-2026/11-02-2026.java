// Equalize the Towers
// Difficulty: MediumAccuracy: 52.18%Submissions: 19K+Points: 4
// You are given an array heights[] representing the heights of towers and another array cost[] where each element represents the cost of modifying the height of respective tower.

// The goal is to make all towers of same height by either adding or removing blocks from each tower.
// Modifying the height of tower 'i' by 1 unit (add or remove) costs cost[i].
// Return the minimum cost to equalize the heights of all the towers.

// Examples:



class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int l = heights[0], r = heights[0];
        int n = cost.length;
        
        for(int h:heights) {
            l = Math.min(l, h);
            r = Math.max(r, h);
        }
        
        while (l <= r) {
            int midH = l + (r - l) / 2;
            
            int costMidMinus1 = findCost(midH-1, heights, cost, n);
            int costMidPlus1  = findCost(midH+1, heights, cost, n);
            int costMid       = findCost(midH,   heights, cost, n);
            
            if (costMidMinus1 >= costMid && costMid <= costMidPlus1) return costMid;
            
            else if (costMidMinus1 >= costMid && costMid > costMidPlus1) l = midH+1;
            
            else r = midH-1;
        }
        
        return -1;
    }
    
    public int findCost(int h, int[] heights, int[] cost, int n) {

        int totCost = 0;
        
        for(int i=0; i<n; i++) {
            int curr = heights[i];
            int diff = Math.abs(curr - h);
            totCost += (diff * cost[i]);
        }
        
        return totCost;
    }
}