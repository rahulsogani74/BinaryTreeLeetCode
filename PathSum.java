public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    public static void main(String[] args) {
        PathSum solution = new PathSum();
        TreeNode root = solution.new TreeNode(5);
        root.left = solution.new TreeNode(4);
        root.right = solution.new TreeNode(8);
        root.left.left = solution.new TreeNode(11);
        root.left.left.left = solution.new TreeNode(7);
        root.left.left.right = solution.new TreeNode(2);
        root.right.left = solution.new TreeNode(13);
        root.right.right = solution.new TreeNode(4);
        root.right.right.right = solution.new TreeNode(1);
        int targetSum = 22;
        boolean hasPath = solution.hasPathSum(root, targetSum);
        System.out.println("Has path with sum " + targetSum + ": " + hasPath);
    }
}
