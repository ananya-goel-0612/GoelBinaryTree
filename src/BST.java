import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Ananya Goel
 * @version: 12/10/2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Overload the function to make it easier to do it recursively
        return search(val, this.getRoot());
    }

    // Helper method for the search function that also takes in a node
    public boolean search(int val, BSTNode node) {
        // Base cases
        // If the values are the same, return true
        if (node.getVal() == val) {
            return true;
        }
        // If the left or right nodes are null, return false
        if (node.getLeft() == null || node.getRight() == null) {
            return false;
        }
        // Recurse and check the left and right nodes
        return (search(val, node.getLeft()) || search(val, node.getRight()));
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Creates the array list that will get returned
        ArrayList<BSTNode> inorder = new ArrayList<BSTNode>();
        return getInorder(this.getRoot(), inorder);
    }

    // Helper method for inorder
    public ArrayList<BSTNode> getInorder(BSTNode node, ArrayList<BSTNode> inorder) {
        // Recurses as long as the node is not null
        if (node != null) {
            // Go to the left node
            getInorder(node.getLeft(), inorder);
            // Add the left node to the array
            inorder.add(node);
            // Go to the right node
            getInorder(node.getRight(), inorder);
        }
        // Once you reach a null node, return the array
        return inorder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preorder = new ArrayList<BSTNode>();
        return getPreorder(this.getRoot(), preorder);
    }

    // Helper method for preorder
    public ArrayList<BSTNode> getPreorder(BSTNode node, ArrayList<BSTNode> preorder) {
        // As long as the node isn't null, recurse
        if (node != null) {
            // Add the root node
            preorder.add(node);
            // Get the left nodes
            getPreorder(node.getLeft(), preorder);
            // Get the right nodes
            getPreorder(node.getRight(), preorder);
        }
        // Return the array once a null node is reached
        return preorder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postorder = new ArrayList<BSTNode>();
        return getPostOrder(this.getRoot(), postorder);
    }

    // Helper method for postorder
    public ArrayList<BSTNode> getPostOrder(BSTNode node, ArrayList<BSTNode> postorder) {
        // Recurses as long as the node is not null
        if (node != null) {
            // Get all the left nodes
            getPostOrder(node.getLeft(), postorder);
            // Get all the right nodes
            getPostOrder(node.getRight(), postorder);
            // Add to the array
            postorder.add(node);
        }
        // Return the array
        return postorder;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        this.root = insert(this.root, val);
    }

    // Helper method for inserting a new node
    private BSTNode insert(BSTNode node, int val) {
        if (node == null) {
            // Create a new node if the current node is null
            return new BSTNode(val);
        }

        // If the node's value is greater than the value,
        // Go to the left
        if (val < node.getVal()) {
            // Insert in the left subtree
            node.setLeft(insert(node.getLeft(), val));
        }
        // Otherwise if the node's value is less than the value,
        // Go to the right
        else if (val > node.getVal()) {
            // Insert in the right subtree
            node.setRight(insert(node.getRight(), val));
        }
        // If the value already exists, don't insert it again
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return isValidBST(this.root, this.root.getLeft(), this.root.getRight());
    }

    // Helper function
    public boolean isValidBST(BSTNode node, BSTNode left, BSTNode right) {
        // If any nodes are null, return true because it hasn't needed to return false yet
        if (node == null || left == null || right == null) {
            return true;
        }

        // If the left node is greater than the root, return false
        if (left.getVal() > node.getVal()) {
            return false;
        }

        // If the right node is greater than the root, return false
        if (right.getVal() < node.getVal()) {
            return false;
        }

        // Call the function again, using the left and right nodes as the roots
        // If any of those calls returns false, return false
        return isValidBST(left, left.getLeft(), left.getRight()) &&
                isValidBST(right, right.getLeft(), right.getRight());
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println(tree.isValidBST());
    }
}
