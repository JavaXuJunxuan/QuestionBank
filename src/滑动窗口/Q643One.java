package 滑动窗口;

/**
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */

public class Q643One {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, maxavg = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (i - start + 1 == k){
                maxavg = Math.max(maxavg,sum/k);
                sum -= nums[start];
                start++;
            }
        }
        return maxavg;
    }
}
