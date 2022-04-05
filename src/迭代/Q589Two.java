package 迭代;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */

public class Q589Two {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if (node != null){
                if (node.children != null){
                    for (int i = node.children.size() - 1; i >= 0; i--){
                        stack.push(node.children.get(i));
                    }
                }
                stack.push(node);
                stack.push(null);
            }else {
                node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
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
