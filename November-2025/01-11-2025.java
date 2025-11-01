// Course Schedule II
// Difficulty: MediumAccuracy: 51.77%Submissions: 89K+Points: 4Average Time: 25m
// You are given n courses, labeled from 0 to n - 1 and a 2d array prerequisites[][] where prerequisites[i] = [x, y] indicates that we need to take course  y first if we want to take course x.

// Find the ordering of courses we should take to complete all the courses.

// Note: There may be multiple correct orders, you just need to return any one of them. If it is impossible to finish all tasks, return an empty array. The Driver code will print true if you return any correct order of courses else it will print false. 


class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indeg = new int[n];
        
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }
        
        for(int i = 0; i < n; i++){
            if(indeg[i] == 0){
                q.add(i);
                ans.add(i);
            }
        }
        
        while(!q.isEmpty()){
            for(int neigh : graph[q.remove()]){
                indeg[neigh]--;
                if(indeg[neigh] == 0){
                    q.add(neigh);
                    ans.add(neigh);
                }
            }
        }
        
        return ans;
    }
}