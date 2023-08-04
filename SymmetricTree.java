public class SymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
    private boolean check(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null || leftRoot.val != rightRoot.val) {
            return false;
        }
        return (leftRoot.val == rightRoot.val)
                && check(leftRoot.left, rightRoot.right)
                && check(leftRoot.right, rightRoot.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        SymmetricTree solution = new SymmetricTree();
        boolean isSymmetric = solution.isSymmetric(root);
        System.out.println(isSymmetric);
    }
}
