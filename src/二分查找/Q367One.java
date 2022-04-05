package 二分查找;

/**
 * 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 */

public class Q367One {
    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        int left = 0, right = num/2;
        while (left < right){
            int mid = (right - left)/2 + left;
            if (mid < num/mid){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left*left == num?true:false;
    }
}
