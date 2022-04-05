package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */

public class Q145One {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
//        先遍历左节点
        postorder(root.left,res);
//        再遍历右节点
        postorder(root.right,res);
//        如果两个节点都为空了把这个父节点值加入集合
        res.add(root.val);
    }
}
