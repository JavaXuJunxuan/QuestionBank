package 二分查找;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 这道题临界情况是比目标值小的那个数（假定为左指针可能为答案），但是比目标值大的那个一定不是答案，所以临界情况应该取出左指针(即答案应该向下取)
 */
public class Q69One {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        int left = 0, right = x / 2;
        while (left < right){
            int mid = (right - left + 1)/2 + left;
            if (mid > x/mid ){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
