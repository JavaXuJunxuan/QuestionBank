package 动态规划;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Q70One {
    public int climbStairs(int n) {
//        定义一个数组来储存每一级楼梯可能的方法数
        int[] dp = new int[n+1];
//        很明显当没有楼梯和只有一级楼梯时只有一种方法
        dp[0] = 1;
        dp[1] = 1;
//        这里这里可以用递归，在不断遍历的同时对每一级楼梯的方法进行计算
        for (int i = 2; i <= n;i++){
           dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
