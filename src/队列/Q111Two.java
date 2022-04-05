package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */

public class Q111Two {
//    public int minDepth(TreeNode root){
//        if (root == null){
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        int depth = 0;
////            每次往队列中加入一个元素（队列节点）这个元素的深度属性都会+1
//        queue.offer(new TreeNode(root,depth+1));
//        while (!queue.isEmpty()){
//            QueueNode nodeDepth = queue.poll();
//            TreeNode node = nodeDepth.node;
//            depth = nodeDepth.depth;
////            这个if是在while循环中，为什么会返回最小深度呢？
////            因为下面左节点和右节点是同时遍历的所以一定会先遍历到一个叶子结点此时返回depth值就可以
//            if (node.left == null && node.right == null){
//                return depth;
//            }
////            当前节点的深度属性是一个值，那么下面两个if中的左节点和右节点如果都存在的话，那么他们的depth相等，
//            if (node.left != null){
//                queue.offer(new QueueNode(node.left,depth+1));
//            }
//            if (node.right != null){
//                queue.offer(new QueueNode(node.right,depth+1));
//            }
//        }
////        这个无所谓只要返回值就行，因为while循环最后一定会找到一个叶子结点
//        return 100000;
//    }
    public int minDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            depth++;
            int length = queue.size();
            while (length>0){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return  depth;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                length--;
            }
        }
        return depth;
    }
}

