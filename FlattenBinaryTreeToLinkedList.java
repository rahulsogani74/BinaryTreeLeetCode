class FlattenBinaryTreeToLinkedList {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode pre = current.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
