package 迭代;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的中序遍历。
 */

public class Q94Two {
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//        当集合（root）为空时前面为false且栈（stk）为空时后面为false此时退出循环
        while (root != null || !stk.isEmpty()){
//            当正在遍历的这个节点不为空时会把它压入栈中
            while (root != null){
                stk.push(root);
//                然后遍历这个节点的左节点知道这个节点的左节点为空退出这个循环
                root = root.left;
            }
//            因为栈是后进先出，所以上面遍历到最底层的节点时可以最先出去然后把这个节点值传入集合
//            只有遍历完当前节点的左子树才会弹出当前节点，然后遍历右子树，当右子树也为空时表示当前节点已经遍历完
//            开始遍历这个节点的上一个节点：先添加上一个节点的节点值再遍历其右子树
            root = stk.pop();
            res.add(root.val);
//            上面那个循环第一次结束时，遍历到了最后一个没有左节点的中间节点上，
//            然后把这个节点值存入集合中后开始遍历它的右节点，再把右节点取出重新遍历这个右节点看看这个右节点还有没有左节点
//            当出现叶子节点（没有左节点也没有右节点）时，因为23行代码赋值了一个空从而退出内层循环，然后会把这个刚刚压入
//            栈中的这个节点弹出来，取出这个中间节点的值（因为左子树遍历完了），再遍历右子树，又因为右子树也为空
//            ，所以只是又会退出内层循环，执行26行出栈代码，但此时弹出的是这个节点的上一个节点（因为这个节点因为左子树为空
//            ，已经弹出去了）
            root = root.right;
        }
        return res;
    }*/

/*    中序遍历特点是深度优先，先把左子树全部遍历完才会加入中间节点，再把右子树遍历完
    这个方法：
    首先是把头结点加入栈中，然后在第一次while循环中先利用node节点标记这个要处理的节点（每次循环node节点都是栈顶节点）
    然后弹出栈顶节点，然后根据中序遍历把右中左节点加入栈中，中间节点为node
    然后每次循环因为node都是栈顶节点，而栈顶节点都为左节点所以达到不断遍历左节点的目的
    当遍历到叶子节点时左右节点都为空所以都不入栈，此时栈顶节点为叶子节点（中间节点）但此时后面会有一个null节点标记*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
//            头结点不为空时把头结点压入栈中
            stack.push(root);
        }
        while (!stack.isEmpty()){
//            定义一个节点等于栈顶结点，这个node始终为要处理的节点：中序遍历所以这个node始终为中间节点
            TreeNode node = stack.peek();
//            只有node
            if (node != null){
//                然后把头结点弹出,防止重复操作,再把右中左节点分别加入栈中
                stack.pop();
                if (node.right!=null){
                    stack.push(root.right);
                }
//                把中间节点加入栈中
                stack.push(node);
//                中间节点访问过但是并没有进行处理，所以加入空节点作为标记
                stack.push(null);
                if (node.left!=null){
                    stack.push(root.left);
                }
//                只有遇到一个空节点（标记：标记着下个节点为要处理的节点）时才会把下个节点放进结果集
            }else {
//                弹出的是一个空节点
                stack.pop();
//                上面的空节点是一个标记节点，标记下面这个要处理的节点
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
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
