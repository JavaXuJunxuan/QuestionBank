package 滑动窗口;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.geom.RectangularShape;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */

public class Q209One {
    public int minSubArrayLen1(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int start = 0;
        for(int end = 0;end < nums.length; end++){
            sum += nums[end];
            while (sum >= target){
                result = Math.min(result,end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        Q209One q209One = new Q209One();
        q209One.minSubArrayLen(7,nums);
    }
    public int minSubArrayLen(int target, int[] nums) {
//      初始化答案变量，过程变量，左指针
        int minResult = Integer.MAX_VALUE , sum = 0, start = 0;
//      遍历目标区间
        for (int end = 0; end < nums.length; end++){
//          维护过程变量
            sum += nums[end];
//          达到题目要求，更新答案变量，且移动窗口找下一个答案
            while (sum >= target){
                minResult = Math.min(minResult, end - start + 1);
                sum -= nums[start];
//              移动左指针
                start++;
            }
        }
//      如果最后都没有符合题目要求的答案则说明目标区间无答案返回0
        if (minResult == Integer.MAX_VALUE) return 0;
        return minResult;
    }
}

