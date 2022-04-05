package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的中序遍历。
 * 访问每个节点都是同一个操作，知道遍历完整棵树，所以可以采用递归
 */
public class Q94One {
    public List<Integer> inorderTraversal(TreeNode root) {
//        初始化一个集合用来储存已经遍历过的节点值
        List<Integer> res = new ArrayList<Integer>();
//        调用遍历方法
        inorder(root,res);
//        递归出来后说明已经遍历完整个二叉树，此时返回集合即可
        return res;

    }
    public void inorder(TreeNode root , List<Integer> res){
//        当遍历的这个节点为空时就返回
//        例如遍历到最后一个没有左节点的中间节点时会执行28行代码，然后又递归进入这个方法
//        此时传入的root为空，直接退出这个方法
        if (root == null){
            return;
        }
//        首先遍历左节点，所以只要左节点一直有就会一直递归调用这个方法传入那个左节点
        inorder(root.left,res);
//        当此时正在遍历的节点左节点为空时才会进入下面这个方法，来把当前这个节点值传入集合
//        此时没有左节点，上一次的左节点此时为中间节点，所以直接添加进去就可以
        res.add(root.val);
//        此时左节点没有中间值添加完后才会遍历右节点
        inorder(root.right,res);
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
