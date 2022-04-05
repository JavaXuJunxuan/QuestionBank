package 二分查找;

import java.io.PrintWriter;

/**
 * 441. 排列硬币
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 */

public class Q441One {
    public static int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = (right - left + 1)/2 + left;
            if ((long)(mid+1)*mid/2 > (long)n){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
