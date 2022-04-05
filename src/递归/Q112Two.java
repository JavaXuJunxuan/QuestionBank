package 递归;

/**
 * 112. 路径总和
 * 给你二叉树的根节点root和一个表示目标和的整数targetSum 。判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回true ；否则，返回false 。
 * 叶子节点是指没有子节点的节点。
 */

public class Q112Two {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
//        遍历到了字节点则判断目标节点总数减去之前遍历过的节点数值是否等于当前叶子节点数值
        if (root.left == null && root.right == null){
            return targetSum == root.val;
        }
//        遍历整个二叉树
        return hasPathSum(root.left,targetSum - root.val)
                || hasPathSum(root.right,targetSum - root.val);
    }
}
