package 动态规划;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */

public class Q53One {
    public int maxSubArray(int[] nums) {
//        定义一个pre用来判断当前遍历的节点处前若干指针的和是否为正
//        maxAns是一个储存最大值的变量，用来不断更新最大值
        int pre = 0,maxAns = nums[0];
        for (int x : nums){
//            只要当前节点的前若干个节点和是正，就和当前下标位置的数进行求和
//            pre+x只有在pre>0时才会比x本身大
            pre = Math.max(pre+x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
