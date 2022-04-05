package 队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 这道题跟102正好输出结果相反，一个是从第一层向最后一层遍历，一个是最后一层向第一层遍历，只需要把结果数组反转一下即可
 */
public class Q107One {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            while (length > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                length--;
            }
            result.add(list);
        }
        int length = result.size()-1;
        for (int i =0; i<=length; i++){
            List<Integer> list1 = result.get(i);
            List<Integer> list2 = result.get(length-i);
//            每次i+1，如果集合有偶数个元素则到中点时i>lenght-i
//            每次i+1，如果集合有奇数个元素则到中点时i=lenght-i
            if (i>=length-i){
                return result;
            }
            result.set(i,list2);
            result.set(length-i,list1);
        }
        return result;
     }
}
