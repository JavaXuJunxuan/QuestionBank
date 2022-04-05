package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给你二叉树的根节点root和一个表示目标和的整数targetSum 。判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回true ；否则，返回false 。
 * 叶子节点是指没有子节点的节点。
 */

public class Q112One {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueVal = new LinkedList<Integer>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()){
//            每次会同时取出节点队列和值队列当中的值，所以当now节点的left或者right不为空时进行值相加时加的是当前节点和其子节点的值
            TreeNode now = queueNode.poll();
            int temp = queueVal.poll();
            if (now.left == null && now.right == null){
                if (targetSum == temp){
                    return true;
                }
            }
            if (now.left != null){
                queueNode.offer(now.left);
                queueVal.offer(now.left.val + temp);
            }
            if (now.right != null){
                queueNode.offer(now.right);
                queueVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
