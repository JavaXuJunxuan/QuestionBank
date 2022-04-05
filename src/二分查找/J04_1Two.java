package 二分查找;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 这道题之所以可以使用二分查找是因为这个二维数组中的每一个元素向右或者向下都是逐渐增大的，而二分查找的条件是通过比大小来不
 * 断缩减答案的区间，所以可以从二维数组左下角或者右上角来
 */

public class J04_1Two {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++){
            int left = 0, right = matrix[i].length - 1;
            while (left < right){
                int mid = (right - left)/2 + left;
                if (matrix[i][mid] < target){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            if (matrix[i][left] == target){
                return true;
            }
//            如果当前行没有找到目标且下一行的第一个元素已经大于目标值，则无目标值，数组规模大时可以提高效率
            if (i < matrix.length - 1 && matrix[i + 1][0] > target) {
                return false;
            }
        }
        return false;
    }
}
