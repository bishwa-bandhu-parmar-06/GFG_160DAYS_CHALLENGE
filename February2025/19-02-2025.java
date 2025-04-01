// Merge K sorted linked lists
// Difficulty: MediumAccuracy: 57.01%Submissions: 96K+Points: 4Average Time: 60m
// Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.


class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        List<Node> list=new ArrayList<>();
        for(Node node:arr){
            Node curr=node;
            while(curr!=null){
                list.add(curr);
                curr=curr.next;
            }
        }
        Collections.sort(list,(a,b)->a.data-b.data);
        for(int i=1;i<list.size();i++){
            list.get(i-1).next=list.get(i);
        }
        return list.get(0);
    }
}