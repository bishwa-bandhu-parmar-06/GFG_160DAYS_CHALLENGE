// Search for Subarray
// Difficulty: HardAccuracy: 46.14%Submissions: 3K+Points: 8
// You are given two integer arrays a[] and b[]. Return all the starting indexes of all the occurences of b[] as a subarray in a[].

// Examples:

// Input: a[] = [2, 4, 1, 0, 4, 1, 1], b[] = [4, 1]
// Output: [1, 4]
// Explanation: b[] occurs as a subarray in a[] from index 1 to 2 and from index 4 to 5.
// Input: a[] = [2, 4, 1, 0, 0, 3], b[] = [0]
// Output: [3, 4]
// Explanation: b[] occurs as a subarray in a[] from index 3 to 3 and from index 4 to 4.
// Input: a[] = [1, 3, 5, 3, 0], b[] = [1, 3, 0]
// Output: []
// Explanation: There is no subarray occurs as b[] in a[]
// Constraints:
// 1 ≤ a.size() ≤ 106
// 1 ≤ b.size() ≤ a.size()
// 0 ≤ b[i], a[i] ≤ 104



class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        int n = a.length,m = b.length;
        int base = 256,md=100000007;
        long pathhash=0,texthash=0,power=1;
        for(int i=0;i<m-1;i++){
            power = (power*base)%md;
        }
        for(int i=0;i<m;i++){
            pathhash = (pathhash*base + a[i])%md;
            texthash = (texthash*base + b[i])%md;
        }
        ArrayList<Integer>ans = new ArrayList<Integer>();
        for(int i=0;i<n-m;i++){
            if(texthash==pathhash)ans.add(i);
            pathhash = (pathhash-(a[i]*power)%md+md)%md;
            pathhash = (pathhash*base + a[i+m])%md;
        }
        if(texthash==pathhash)ans.add(n-m);
        return ans;
    }
}