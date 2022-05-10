package 模拟;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */

public class Q54One {
    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int num = -101;
//        等于时也需要进入循环，因为等于时相交的那一行或者一列的数据还没有保存，且必须同时成立，只要有一个不成立就表示遍历完了整个数组
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
//            只有上面的代码可能会导致大于的情况发生，这里不发生那么下面一定会执行且只有下面等于的时候下次循环不进入
            if (top > bottom || left > right) break;
            for (int i = right; i >= left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        Q54One q54One = new Q54One();
        int[][] ints = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(q54One.spiralOrder(ints));

    }
}
