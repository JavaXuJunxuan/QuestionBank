package 递归;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */

public class Q101One {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p,TreeNode q){
//        当p和q都为空时返回true
        if (p == null && q == null){
            return true;
        }
//        已经排除p和q都为空的情况，所以只有pq都不为空时才会执行后续代码，否则返回false
        if (p == null || q == null){
            return false;
        }
//        每个节点判断相等条件一样，所以递归，但要注意每次都要不断遍历节点
        return p.val == q.val && check(p.left,q.right) && check(q.left,p.right);
    }
}
