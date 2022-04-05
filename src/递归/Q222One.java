package 递归;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的
 * 节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2的h次方个节点。
 */

public class Q222One {
    /*public int countNodes(TreeNode root) {
        int count = 0;
        count = bianli(root,count);
        return count;
    }
    int bianli(TreeNode root,int count){
        if (root == null){
            return count;
        }
        count++;
        if (root.left != null){
            count = bianli(root.left,count);
        }
        if (root.right != null){
            count = bianli(root.right,count);
        }
        return count;
    }*/

    /*public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }*/

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
