// Gray Code
// Difficulty: MediumAccuracy: 61.87%Submissions: 10K+Points: 4
// Given a number n, generate bit patterns from 0 to 2(n-1) such that successive patterns differ by one bit. 
// A Gray code sequence must begin with 0.
 


class Solution {

    public ArrayList<String> graycode(int n) {

        ArrayList<String>ans=new ArrayList<>();

        for(int i=0;i<(1<<n);i++){

            int val=(i^(i>>1));

            StringBuilder sb=new StringBuilder();

            for(int j=n-1;j>=0;j--){

                if((val&(1<<j))!=0)

                sb.append('1');

                else

                sb.append('0');

            }

        

        ans.add(sb.toString());

        }

        return ans;

    }

}