// Intersection in Y Shaped Lists
// Difficulty: MediumAccuracy: 44.67%Submissions: 318K+Points: 4Average Time: 45m
// You are given the heads of two non-empty singly linked lists, head1 and head2, that intersect at a certain point. Return that Node where these two linked lists intersect.

// Note: It is guaranteed that the intersected node always exists.

// In the custom input you have to give input for CommonList which pointed at the end of both head1 and head2 to form a Y-shaped linked list.


class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        if(head1 == null || head2== null) return null;
        Node a = head1;
        Node b=head2;
        while(a!=b) {
            if(a==null) {
                a=head2;
            } else {
                a=a.next;
            }
            if(b==null){
                b=head1;
            } else {
                b=b.next;
            }
        }
        return a; 
    }
}