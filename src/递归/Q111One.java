package 递归;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */

public class Q111One {
    public int minDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
//        因为题目要求是根节点到最近叶子节点所以必须有叶子节点，上面已经排除了两个子节点都为空的情况，所以当前节点的根节点一定有子节点
        if (root.left != null) {
            min_depth = Math.min(height(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(height(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
