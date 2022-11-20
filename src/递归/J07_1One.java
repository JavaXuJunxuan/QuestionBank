package 递归;

import java.util.HashMap;
import java.util.Map;

public class J07_1One {
    Map<Integer,Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return recur(0,0,inorder.length - 1);
    }
    TreeNode recur(int pre_root, int left, int right){
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[pre_root]);
        int index = map.get(preorder[pre_root]);
        root.left = recur(pre_root + 1, left , index - 1);
        root.right = recur(pre_root + index - left + 1 , index + 1, right);
        return root;
    }
}
