// Next Smallest Palindrome
// Difficulty: HardAccuracy: 19.63%Submissions: 67K+Points: 8
// Given a number, in the form of an array num[] containing digits from 1 to 9(inclusive). Find the next smallest palindrome strictly larger than the given number.

// Examples:

// Input: num[] = [9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2]
// Output: [9, 4, 1, 8, 8, 0, 8, 8, 1, 4, 9]
// Explanation: Next smallest palindrome is 9 4 1 8 8 0 8 8 1 4 9.
// Input: num[] = [2, 3, 5, 4, 5]
// Output: [2, 3, 6, 3, 2]
// Explanation: Next smallest palindrome is 2 3 6 3 2.
// Constraints:
// 1 ≤ n ≤ 105
// 1 ≤ num[i] ≤ 9


class Solution {

    static int[] nextPalindrome(int[] num) {

        int n=num.length;

        boolean allNine=true;

        for(int d:num)

        if(d!=9){

            allNine=false;

            break;

        }

        if(allNine){

        int[]ans=new int[n+1];

        ans[0]=1;

        ans[n]=1;

        return ans;

        }

        int[]ans=Arrays.copyOf(num,n);

        int mid=n/2;

        for(int i=0;i<mid;i++)

        ans[n-i-1]=ans[i];

        if(isSmallerOrEqual(ans,num)){

        int i=(n%2==0)?mid-1:mid;

        int carry=1;

        while(i>=0&&carry>0){

        ans[i]+=carry;

        carry=ans[i]/10;

        ans[i]%=10;

        ans[n-1-i]=ans[i];

        i--;

        }

        }

        return ans;

    }

    private static boolean isSmallerOrEqual(int[]a,int[]b){

        for(int i=0;i<a.length;i++){

          if(a[i]<b[i]) return true;

          if(a[i]>b[i]) return false;

        }

        return true;

    }

}

