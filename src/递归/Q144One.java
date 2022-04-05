package 递归;

/*
144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的前序遍历。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Q144One {
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }
    public void preorder(TreeNode node,List<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
//        先把右节点入栈再把左节点入栈是因为栈是后进先出，所以只有把左节点后入栈，才会有左节点先出栈遍历
//        遍历每一个节点时都会先把这个节点出栈，保证只会遍历一次这个节点，出栈时就会把这个节点值加入数组中
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
//            空节点不入栈
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
