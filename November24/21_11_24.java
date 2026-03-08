class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int Prof = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                Prof += prices[i + 1] - prices[i];
            }
        }
        return Prof;
    }
}
