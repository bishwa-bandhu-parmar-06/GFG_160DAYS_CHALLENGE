// K closest Values
// Difficulty: MediumAccuracy: 79.1%Submissions: 5K+Points: 4
// Given the root of a Binary Search Tree, a target value, and an integer k. Your task is to find the k values in the BST that are closest to the target.

// The closest value is taken by choosing the one that gives minimum absolute difference from target.

// Note: In case two values have same absolute difference from target, choose the smaller one. The target may or may not be present in BST.
// You can return the values in any order the driver code will print them in sorted order only.


class Solution {
    int idx; int min; int val;
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        min = Integer.MAX_VALUE; idx = -1; val = -1;
        inorder(root,list,target);
        int left = idx; int right = idx+1;
        int n = list.size();
      
        while(left >= 0 && right < n && k > 0){
            if(Math.abs(target - list.get(left)) > Math.abs(target - list.get(right))){
                ans.add(list.get(right));
                right++;
            }else{
                ans.add(list.get(left));
                left--;
            }
            k--;
        }
        
        while(k > 0 && left >= 0){
            ans.add(list.get(left--));
            k--;
        }
        
        while(k > 0 && right < n){
            ans.add(list.get(right++));
            k--;
        }
        
        return ans;
    }
    private void inorder(Node root, List<Integer> list, int tar){
        if(root == null) return;
       
        inorder(root.left,list,tar);
        list.add(root.data);
        int diff = Math.abs(root.data - tar);
        if(diff <= min){
            if(diff == min && val > root.data){
                val = root.data;
                idx = list.size()-1;
            }else if(diff < min){
                min = diff;
                val = root.data;
                idx = list.size()-1;
            }
        }
        inorder(root.right,list,tar);
    }
}