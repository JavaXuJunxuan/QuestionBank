package 队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102One {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        if (root == null){
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
//          length就是这一层中元素的数量
            int length = queue.size();
//            下面这段代码就是遍历这一层，因为队列是先进先出所以哪怕下面代码会把节点的左右节点加入队列，也只会遍历最开始
//            统计的length个数据
            while (length>0){
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
            resList.add(list);
        }
        return resList;
    }
}
