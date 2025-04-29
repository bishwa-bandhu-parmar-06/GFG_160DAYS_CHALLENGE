// Sort a linked list of 0s, 1s and 2s
// Difficulty: MediumAccuracy: 60.75%Submissions: 243K+Points: 4Average Time: 30m
// Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.



class Solution {
    static Node segregate(Node head) {
        // code here
        int[] freq=new int[3];
        Node temp=head;
        while(temp!=null){
            freq[temp.data]++;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<3;i++){
            int count=i;
            while(freq[count]--!=0){
                temp.data=i;
                temp=temp.next;
            }
        }
        
        return head;
    }
}