// Huffman Encoding
// Difficulty: HardAccuracy: 32.4%Submissions: 53K+Points: 8Average Time: 30m
// Given a string s of distinct characters and their corresponding frequency f[ ] i.e. character s[i] has f[i] frequency. You need to build the Huffman tree and return all the huffman codes in preorder traversal of the tree.
// Note: While merging if two nodes have the same value, then the node which occurs at first will be taken on the left of Binary Tree and the other one to the right, otherwise Node with less value will be taken on the left of the subtree and other one to the right.



class Solution {
    
    static class Node {
        int freq;
        int idx;
        Node left, right;
        
        Node(int f, int i) {
            freq = f;
            idx = i;
            left = right = null;
        }
    }
    
    // Custom Comparator (same as C++ Compare)
    static class Compare implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.freq == b.freq) {
                return a.idx - b.idx; // smaller index first
            }
            return a.freq - b.freq; // smaller freq first
        }
    }
    
    // Build Huffman Codes (Preorder)
    public void buildCodes(Node root, String code, ArrayList<String> ans) {
        if (root == null) return;
        
        // Leaf node
        if (root.left == null && root.right == null) {
            ans.add(code);
            return;
        }
        
        buildCodes(root.left, code + "0", ans);
        buildCodes(root.right, code + "1", ans);
    }
    
    public ArrayList<String> huffmanCodes(String s, int f[]) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        
        int n = s.length();
        
        // Step 1: push all nodes
        for (int i = 0; i < n; i++) {
            pq.add(new Node(f[i], i));
        }
        
        // Edge case: only one character
        if (n == 1) {
            ArrayList<String> single = new ArrayList<>();
            single.add("0");
            return single;
        }
        
        // Step 2: build tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            
            Node parent = new Node(
                left.freq + right.freq,
                Math.min(left.idx, right.idx)
            );
            
            parent.left = left;
            parent.right = right;
            
            pq.add(parent);
        }
        
        // Step 3: generate codes
        ArrayList<String> ans = new ArrayList<>();
        buildCodes(pq.peek(), "", ans);
        
        return ans;
    }
}