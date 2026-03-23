// Length of Longest Cycle in a Graph
// Difficulty: HardAccuracy: 61.85%Submissions: 11K+Points: 8
// Given an directed graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v. Each node has at most one outgoing edge.

// Your task is to find the length of the longest cycle present in the graph. If no cycle exists, return -1.

// Note: A cycle is a path that starts and ends at the same vertex.

// Examples :


class Solution {
    public int longestCycle(int v, int[][] mat) {
        // code here
        int n=mat.length,res=-1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(mat[i][0],mat[i][1]);
        }
        for(int i=0;i<v;i++){
            boolean vis[]=new boolean[v];
            int p=i,c=0;
            boolean de=false;
            while(vis[p]==false){
                vis[p]=true;c++;
                if(hm.containsKey(p))
                    p=hm.get(p);
                else{
                    de=true;
                    break;
                }
            }
            if(!de && p==i)
                res=Math.max(res,c);
        }
        return res;
    }
}