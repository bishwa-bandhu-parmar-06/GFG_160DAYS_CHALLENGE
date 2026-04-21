// Two water Jug problem
// Difficulty: MediumAccuracy: 48.78%Submissions: 16K+Points: 4Average Time: 20m
// You are at the side of a river. You are given a m litre jug and a n litre jug . Both the jugs are initially empty. The jugs dont have markings to allow measuring smaller quantities. You have to use the jugs to measure d litres of water . Determine the minimum no of operations to be performed to obtain d litres of water in one of the jugs.
// The operations you can perform are:

// Empty a Jug
// Fill a Jug
// Pour water from one jug to the other until one of the jugs is either empty or full.


class Solution {
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int minSteps(int m, int n, int d) {
        // code here
        if(d>Math.max(m,n)) return -1;
        if(d%gcd(m,n)!=0) return -1;
        int ans1 = solve(m,n,d);
        int ans2 = solve(n,m,d);
        return Math.min(ans1,ans2);
    }
    public int solve(int fromcap,int tocap,int d){
        int from = fromcap;
        int to =0;
        int steps = 1;
        while(from!=d && to!=d){
            int temp =  Math.min(from,tocap-to);
            to+=temp;
            from-=temp;
            steps++;
            if(from==d || to==d){
                break;
            }
            if(from==0){
                from=fromcap;
                steps++;
            }
            if(to ==tocap){
                to=0;
                steps++;
            }
        }
        return steps;
        
    }
}