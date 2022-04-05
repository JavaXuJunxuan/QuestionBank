package 二分查找;

import sun.reflect.generics.tree.Tree;

public class Q240One {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = matrix[i].length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (matrix[i][left] == target) return true;
        }
        return false;
    }
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int left = matrix.length - 1, right = 0;
        while (left >= 0 && right < matrix[0].length){
            if (matrix[left][right] < target){
                right++;
            }else if (matrix[left][right] > target){
                left--;
            }else {
                return true;
            }
        }
        return false;
    }*/
}
