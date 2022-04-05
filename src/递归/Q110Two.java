package 递归;

import sun.reflect.generics.tree.Tree;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 */

public class Q110Two {
    public boolean isBalanced(TreeNode root) {
        return height(root) > -1;
    }
    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int righrHeight = height(root.right);
        if (leftHeight == -1 || righrHeight == -1 || Math.abs(leftHeight - righrHeight) > 1){
            return -1;
        }else {
            return Math.max(leftHeight,righrHeight)+1;
        }
    }
}
