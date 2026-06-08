// Delete Nodes with Greater on Right
// Difficulty: EasyAccuracy: 35.51%Submissions: 153K+Points: 2Average Time: 30m
// Given a singly linked list, remove all nodes that have a node with a greater value anywhere to their right in the list. Return the head of the modified linked list.

// Examples


class Solution {
    Node compute(Node head) {
        // code here
        Stack<Node> st = new Stack<>();
        
        Node root = head;
        while(root != null){
            
            while(!st.isEmpty() && st.peek().data < root.data){
                st.pop();
            }
            if(!st.isEmpty()){
                st.peek().next = root;
            }
            st.push(root);
            root = root.next;
        }
        
        while(!st.isEmpty()){
            head = st.pop();
        }
        return head;
    }
}