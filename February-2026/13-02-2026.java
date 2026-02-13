// All numbers with specific difference
// Difficulty: HardAccuracy: 42.34%Submissions: 8K+Points: 8
// Given a positive number n and a number d. Find the count of positive numbers smaller or equal to n such that the difference between the number and sum of its digits is greater than or equal to given specific value d.





class Solution {
    
    public boolean checkIsValid(long val , long d){
        long temp = val;
        long digitsSum = 0;
        while(val > 0){
            long rem = val % 10;
            digitsSum += rem;
            val = val / 10;
        }
        return (temp - digitsSum) >= d;
    }
    public int getCount(int n, int d) {
        // code here
        long D = (long)d;
        long left = 1;
        long right = (long)n;
        long leftMostVal = -1;
        
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(checkIsValid(mid , D)){
                leftMostVal = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return leftMostVal == -1 ? 0 : (int)((long)n - leftMostVal + 1);
    }
};