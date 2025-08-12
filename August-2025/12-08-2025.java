// Shop in Candy Store
// Difficulty: MediumAccuracy: 45.43%Submissions: 86K+Points: 4
// In a candy store, there are different types of candies available and prices[i] represent the price of  ith types of candies. You are now provided with an attractive offer.
// For every candy you buy from the store, you can get up to k other different candies for free. Find the minimum and maximum amount of money needed to buy all the candies.
// Note: In both cases, you must take the maximum number of free candies possible during each purchase.



class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int n=prices.length;
        int i=0,j=n-1;
        Arrays.sort(prices);
        ArrayList<Integer>res=new ArrayList<>();
        int s=0;
        while(i<=j)
        {
            s+=prices[i];
            i++;
            for(int a=0;a<k;a++)
            {
                j--;
            }
        }
        res.add(s);
        s=0;i=0;j=n-1;
        while(i<=j)
        {
            s+=prices[j];
            j--;
            for(int a=0;a<k;a++)
            {
                i++;
            }
        }
        res.add(s);
        return res;
    }
}
