// Maximum Sum Combination
// Difficulty: MediumAccuracy: 49.69%Submissions: 87K+Points: 4Average Time: 30m
// You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by adding one element from a[] and one from b[], using each index pair (i, j) at most once. Return the top k maximum sum combinations, sorted in non-increasing order.



class Solution {
    public ArrayList<Integer> topKSumPairs(int[] A, int[] B, int K) {
        // code here
        int N = A.length;
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
    
         for(int i=N-1;i>N-1-K;i--){
            for(int j=N-1;j>N-1-K;j--){
            int sum=A[i]+B[j];
            if(pq.size()<K){
                pq.add(sum);
            }
            else if(sum>pq.peek()){
                pq.poll();
                pq.add(sum);
            }
            else break;
        }
    }
    
    while(pq.size()>0){
        list.add(0,pq.poll());
    }
    return list;
  }
}

