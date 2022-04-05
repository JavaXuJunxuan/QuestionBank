package 递归;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */

public class Q104One {
    //    这里通过先遍历根节点的左子树再遍历右子树来进行递归解决问题
//    每一个节点都会调用一次这个方法，然后执行把左节点和右节点分别代入18和19行代码，最后必然会执行20行代码进行+1处理这个1代表
//    当前调用这个方法的节点
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}













    /*public  int maxDepth(TreeNode root) {
        int n = 1;
         n = search(root.left,root.right,n);
         return n;
    }
    public  int search(TreeNode left,TreeNode right,int n){
        int n1,n2;
        if (left == null && right == null){
            return n;
        }
        n++;
        if (left != null ){
             left = left.left;
             right = left.right;
        }else if (right != null){
            left = right.left;
            right = right.right;
        }
        n1 = search(left,right,n);
        n2 = search(left,right,n);
        n = Math.max(n1,n2);
        return n;
    }*/
