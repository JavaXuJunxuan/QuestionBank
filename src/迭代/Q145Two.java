package 迭代;

/**
 * 145. 二叉树的后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */

import java.util.*;

public class Q145Two {
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return list;
        }
        TreeNode prev = null;
//        因为遍历的节点可能为空值所以用或
//        因为是后序遍历，所以首先要判断左节点为空在判断右节点为空然后把这个节点值加入list最后弹出这个元素
        while(!stack.isEmpty() || root != null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
//                当一个节点的左右节点都为空时把这个节点值加入集合，然后把这个节点弹出
//            root = null是为了让上面的循环跳过目的是取出下一个栈中的元素（也就是上一个节点的父节点）
//            root.right == prev的确保遍历过右节点的节点不会重复遍历
            if (root.right == null || root.right == prev) {
//                右节点为空，因为后序遍历，此时左右都遍历过，所以可以增加值了
                list.add(root.val);
//                prev是一个标识，标识这个节点已经遍历过了
                prev = root;
//                然后root赋值空来确保当前遍历的这个节点的父节点能成功出栈
                root = null;
//                出栈后如果他右节点等于prev即标识它的右节点已经遍历过了会执行上面这个if来把这个值加入集合，然后继续向上遍历
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right!=null){
                    stack.push(node.right);
                }
                if (node.left!=null){
                    stack.push(node.left);
                }
            }else {
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
