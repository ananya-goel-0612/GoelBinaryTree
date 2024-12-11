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
        // Creates the array list that will get returned
        ArrayList<BSTNode> inorder = new ArrayList<BSTNode>();
        return getInorder(this.getRoot(), inorder);
    }

    // Helper method for inorder
    public ArrayList<BSTNode> getInorder(BSTNode node, ArrayList<BSTNode> inorder) {
        // TODO: Complete inorder traversal

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> preorder = new ArrayList<BSTNode>();
        return getPreorder(this.getRoot(), preorder);
    }

    public ArrayList<BSTNode> getPreorder(BSTNode node, ArrayList<BSTNode> preorder) {
        // TODO: Complete preorder traversal

    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> postorder = new ArrayList<BSTNode>();
        return getPostOrder(this.getRoot(), postorder);
    }

    public ArrayList<BSTNode> getPostOrder(BSTNode node, ArrayList<BSTNode> postorder) {
        // TODO: Complete postorder traversal

    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert

    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
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
    }
}
