// Interleave the First Half of the Queue with Second Half
// Difficulty: MediumAccuracy: 62.41%Submissions: 21K+Points: 4Average Time: 20m
// Given a queue q[] of even size. Your task is to rearrange the queue by interleaving its first half with the second half.

// Interleaving is the process of mixing two sequences by alternating their elements while preserving their relative order.
// In other words, Interleaving means place the first element from the first half and then first element from the 2nd half and again second element from the first half and then second element from the 2nd half and so on....


class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        List<Integer> list = new ArrayList<>();
        boolean isRev = false;
        
        while(!q.isEmpty()){
            int mid = q.size()/2;
            
            if(isRev){
                
                list.add(q.poll());
                mid--;
                
                while(mid-- > 0){
                    q.add(q.poll());
                }
                
                list.add(list.size()-1,q.poll());
            } else {
                list.add(q.poll());
                mid--;
                while(mid-- > 0){
                    q.add(q.poll());
                }
                list.add(q.poll());
            }
            
            isRev = !isRev;
        }
        for(int v : list){
            q.add(v);
        }
    }
}