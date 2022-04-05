package 队列;

import java.util.*;

/**
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */

public class Q515One {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
//            int max = Integer.MIN_VALUE;
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            while (length > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                length--;
            }
            result.add(Collections.max(list));
            /*for (Integer integer : list){
                max = Math.max(max,integer);
            }
            result.add(max);*/
        }
        return result;
    }
}
