package 二分查找;

/**
 * 剑指 Offer II 068. 查找插入位置
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */

public class J68One {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right){
            int mid = (right - left)/2 + left;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
