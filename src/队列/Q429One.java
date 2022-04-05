package 队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q429One {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            while (length > 0){
                Node node = queue.poll();
                list.add(node.val);
                if (node.children!=null){
                    /*int size = node.children.size();
                    for (int i =0; i < size; i++){
                        queue.offer(node.children.get(i));
                    }*/
                    for (Node node1 :node.children){
                        queue.offer(node1);
                    }
                }
                length--;
            }
            result.add(list);
        }
        return result;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
