package 递归;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 */

public class Q110One {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }else {
//      abs是用来求绝对值的，只有下面语句返回true时才可以判断当前节点的为平衡二叉树
            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int height(TreeNode root){
        if (root == null){
            return 0;
        }else {
//            这里就是递归调用height函数直到传入的节点为null
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }
}
