package 二分查找;
import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */

public class Q209One {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[length + 1];
//        这里从下标为1取值，因为sums中元素为前i个元素和，0到nums
//        int数组默认是0所以nums[0]==0.
        for (int i =1; i <= length; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
//        对于每一个和数组的元素都查找一下是不是长度最小的子数组
        for(int i = 0; i< length; i++){
//            最后一个sums【length】不需要判断，因为下面是在sums这个数组中找，sums[length]+1个数不可能
//            在sums[length]中找到下标，所以返回的是length+1的反码
            int result = target + sums[i];
//            这里index如果在数组中有返回的就是target+sunms[i-1]这两个数的和的那个数在数组的下标位置
            int index = Arrays.binarySearch(sums,result);
            if (index < 0){
//                这里相当于对index取反，因为数组的二分查找找不到元素时会返回一个负数，负数取反就是这个元素应该插入的下标
                index = -index - 1;
            }
//            每次index都有值，把最小的取出来
            if(index <= length){
                min = Math.min(min,index - i);
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}
