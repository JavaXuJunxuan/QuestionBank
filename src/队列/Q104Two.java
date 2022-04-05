package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */

public class Q104Two {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
//        创建一个队列进行储存二叉树中的节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        把根节点先储存进去
        queue.offer(root);
//        ans就是二叉树的最大深度
        int ans = 0;
//        每次把一层中所有的节点全部压入队列中
        while (!queue.isEmpty()){
//            下面这个循环的目的就是遍历每一层的所有节点
            int size = queue.size();
            while (size > 0){
//                每次取出一个节点然后size-1就是为了查找这个节点是否还有子节点，是为了下次遍历做准备
                TreeNode node = queue.poll();
                size--;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
//            每遍历完一次就会让ans+1
            ans++;
        }
//        队列为空时会退出上面的循环然后返回层数
        return ans;
    }
}
