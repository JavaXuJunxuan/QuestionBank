package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */

public class Q100Two {
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        当两个都为空时一定相等直接返回true
        if (p == null && q == null){
            return true;
//            下面这个条件语句是用来排除一个为空一个不为空的情况的
        }else if (p == null || q == null){
            return false;
        }
//        两个都不为空时才会执行下面的代码
//        使用两个队列分别存储两个二叉树的节点。初始时将两个二叉树的根节点分别加入两个队列。每次从两个队列各取出一个节点
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
//        短路与表示两个队列都不能为空才会进入循环
        while (!queue1.isEmpty() && !queue2.isEmpty()){
//            取出两个队列中的元素
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
//            如果取出的元素不相等则返回false，相等才会执行后续的代码
            if (node1.val != node2.val){
                return false;
            }
//            根节点相同时分别取两个根节点的左节点和右节点
            TreeNode left1 = node1.left,right1 = node1.right,left2 = node2.left,right2 = node2.right;
//            ^运算符判断布尔类型时：全为true或者false时结果为false，一正一负为true，true则执行大括号的代码
//            所以下面两个条件语句只有两个都为空或者两个都不为空才会执行后续代码，否则直接返回false值
            if (left1 == null ^ left2 == null){
                return false;
            }
            if (right1 == null ^ right2 == null){
                return false;
            }
//            为什么每个节点都需要判断一次呢？
//            因为上面的条件判断中,如果两个节点都为空也会执行下面的代码
//            下面的代码都是成对执行的，如果执行left1则right1也会执行，如果执行left2则right2也会执行
            if(left1 != null){
                queue1.offer(left1);
            }
            if(right1 != null){
                queue1.offer(right1);
            }
            if(left2 != null){
                queue2.offer(left2);
            }
            if(right2 != null){
                queue2.offer(right2);
            }
        }
//        如果搜索结束时两个队列同时为空，则两个二叉树相同。如果只有一个队列为空，则两个二叉树的结构不同，因此两个二叉树不同。
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
