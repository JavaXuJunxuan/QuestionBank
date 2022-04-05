package 队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Q199One {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        因为是输出每层最后一个元素，所以仍然需要知道每层的长度length
        while (!queue.isEmpty()){
            int length = queue.size();
//            遍历每层的元素，取出最后一个加入集合
            for (int i =0; i<length; i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (i==length-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
