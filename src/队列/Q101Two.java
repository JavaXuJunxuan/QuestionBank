package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */

public class Q101Two {
    public boolean isSymmetric(TreeNode root) {
        return  check(root,root);
    }
    public boolean check(TreeNode u, TreeNode v){
//        创建一个队列来储存二叉树的节点
        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        把节点入队两次因为要比较一个数是否为对称，要左右节点一起遍历
        q.offer(u);
        q.offer(v);
//        q不为空就会一直遍历下去
        while (!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            if (u == null && v == null){
                continue;
            }
//            当u或者v有一个空时或者uv的值不相等时会返回false
            if ((u == null || v == null) || (u.val != v.val)){
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);
            q.offer(u.right);
            q.offer(v.left);
        }
//        当不出现中途返回false表示正常遍历完二叉树退出循环代表对称
        return true;
    }
}
