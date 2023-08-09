public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int l = inorder.length;
        return helper(inorder, postorder, 0, l - 1, 0, l - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int instart, int inEnd, int postStart, int postEnd) {
        if (instart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = instart;
        for (; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }
        int leftTreeSize = rootIndex - instart;
        int rightTreeSize = inEnd - rootIndex;
        root.left = helper(inorder, postorder, instart, rootIndex - 1, postStart, postStart + leftTreeSize - 1);
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postStart + leftTreeSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(inorder, postorder);
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.val);
        printTree(node.left, level + 1);
    }
}