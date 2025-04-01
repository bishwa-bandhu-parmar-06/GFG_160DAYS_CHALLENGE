// Serialize and deserialize a binary tree
// Difficulty: MediumAccuracy: 51.67%Submissions: 91K+Points: 4Average Time: 45m
// Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

// serialize() : stores the tree into an array a and returns the array.
// deSerialize() : deserializes the array to the tree and returns the root of the tree.
// Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).


class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node == null) {
                result.add(-1); // Using -1 to represent null
            } else {
                result.add(node.data);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return result;
    }
    
    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr.isEmpty() || arr.get(0) == -1) return null;
        
        Node root = new Node(arr.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.size()) {
            Node current = queue.poll();
            
            if (arr.get(i) != -1) {
                current.left = new Node(arr.get(i));
                queue.add(current.left);
            }
            i++;
            
            if (i < arr.size() && arr.get(i) != -1) {
                current.right = new Node(arr.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}