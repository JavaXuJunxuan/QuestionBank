package 暴力解法;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 此为暴力解法，通过遍历数组来找到答案
 */
public class Q1One {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for(int i =0;i<nums.length;i++){
            for (int j =i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    ints[0]=i;
                    ints[1]=j;
                    return ints;
                }
            }
        }
        return new int[]{-1,-1};
    }
}
