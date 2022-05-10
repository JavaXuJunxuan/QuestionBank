package 模拟;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */

public class Q59One {
    public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1, target = n * n;
        while (num <= target){
            for (int i = left; i <= right; i++){
                ints[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++){
                ints[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--){
                ints[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--){
                ints[i][left] = num++;
            }
            left++;
        }
        return ints;
    }
}
