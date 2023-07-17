import javax.swing.tree.TreeNode;

public class InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        TreeNode invertedTree = invertBinaryTree.invertTree(root);

        System.out.println("      " + invertedTree.val);
        System.out.print("  " + invertedTree.left.val);
        System.out.println("       " + invertedTree.right.val);
        System.out.print(invertedTree.left.left.val);
        System.out.print("  " + invertedTree.left.right.val);
        System.out.print("    " + invertedTree.right.left.val);
        System.out.print("  " + invertedTree.right.right.val);
    }
}
