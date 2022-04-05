package 迭代;

/*
144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的前序遍历。
 */

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.*;

public class Q144Two {
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
//        创建一个存储头结点地址的新节点，然后不断遍历这个新节点
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
//            这个while方法会一直把左子树遍历完才会退出循环
//            每次压元素进栈必须时当前元素不为空，先添加值在入栈
            while (treeNode != null){
//                先序遍历先添加节点值再把节点入栈然后遍历左节点，左节点为空则出循环然后把父节点出栈判断右节点（先序遍历），
//                头节点在栈的底部
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
//            当上面那个节点为空时表明上个节点的左节点为空，这个为空的节点并没有入栈，所以下面
//            弹出的元素为这个空节点的上一个节点，此时把这个节点弹出然后遍历这个弹出节点的右节点，如此循环
            treeNode = stack.pop();
            treeNode = treeNode.right;
        }
        return list;
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            }else {
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
