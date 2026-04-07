// Manual tree traversal demo:
// This example builds a tree by wiring nodes manually and prints DFS traversals.
class TraversalNode {
    int data;
    TraversalNode left;
    TraversalNode right;

    TraversalNode(int key) {
        data = key;
        left = right = null;
    }
}

class ManualTraversalTree {
    TraversalNode root = null;

    void inorderTraversal(TraversalNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void preOrderTraversal(TraversalNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(TraversalNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        ManualTraversalTree tree = new ManualTraversalTree();

        // Manually building a sample tree for traversal demonstration.
        tree.root = new TraversalNode(27);
        tree.root.left = new TraversalNode(12);
        tree.root.right = new TraversalNode(3);
        tree.root.left.left = new TraversalNode(44);
        tree.root.left.right = new TraversalNode(17);
        tree.root.right.left = new TraversalNode(56);

        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPreorder traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postOrderTraversal(tree.root);
    }
}
