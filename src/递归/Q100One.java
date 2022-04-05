package 递归;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */

public class Q100One {
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        如果两个二叉树都为空则相等
        if(p == null && q == null){
            return true;
//            因为上面已经排除了两个都为空的情况，所以只剩下了都不为空和一个为空的情况
//            下面的条件语句只有都不为空才会进入之后的代码，一个为空直接返回false
        }else if (p == null || q == null){
            return false;
//            只要一个节点值不对应相等直接返回false
        }else if ((p.val != q.val)){
            return false;
//      代码进行到这表示两个节点都不为空且当前对应节点值也相等，下面需要遍历其他节点，因为每次遍历操作都相等所以可以用递归
        }else {
//            这里因为是短路与操作，并且先递归二叉树的左子树，左子树遍历完才会进入右子树
//            但短路与如果左子树最终返回false则会直接返回false
//            只有左子树返回true才会遍历右子树
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}

