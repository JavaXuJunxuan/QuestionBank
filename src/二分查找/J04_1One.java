package 二分查找;

import sun.security.util.Length;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 这道题之所以可以使用这个方法是因为这个二维数组中的每一个元素向右或者向下都是逐渐增大的，而这个解法就是通过比大小来不
 * 断缩减答案的区间，所以可以从二维数组左下角或者右上角来不断缩减区间
 */

public class J04_1One {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                j++;
            }else return true;
        }
        return false;
    }
}
