// Course Schedule I
// Difficulty: MediumAccuracy: 79.05%Submissions: 4K+Points: 4
// You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y] indicates that we need to take course y first if we want to take course x.

// Find if it is possible to complete all tasks. Return true if all tasks can be completed, or false if it is impossible.


class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int []indegree = new int[n];
        for(int []it:prerequisites)
        {
            int u = it[0];
            int v = it[1];
            adj.get(v).add(u);
            }
            for(int i=0;i<n;i++)
            {
                for(int it:adj.get(i))
                {
                    indegree[it]++;
                }
            }
            int count =0;
            Queue<Integer>q = new LinkedList<>();
            for(int i=0;i<n;i++)
            {
                if(indegree[i]==0)
                {
                    q.add(i);
                }
            }
            while(!q.isEmpty())
            {
                int node = q.peek();
                q.remove();
                count++;
                for(int it:adj.get(node))
                {
                    indegree[it]--;
                    if(indegree[it]==0)
                    {
                        q.add(it);
                    }
                }
            }
            if(count ==n)
            {
                return true;
            }
            
            return false;
    }
}