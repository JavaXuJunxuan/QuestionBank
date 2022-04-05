package 二分查找;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * cv34题代码殊途同归都是查找元素第一个和最后一个下标
 */

public class J53One {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        int firstPosition = findFirstPosition(nums,target);
        int lastPosition = findLastPosition(nums, target);
        return firstPosition == -1?0:lastPosition - firstPosition + 1;
    }
    private int findFirstPosition(int[] nums, int target) {
        int left1 = 0, right1 = nums.length - 1;
        while (left1 < right1){
            int mid = (right1 - left1)/2 + left1;
            if (nums[mid] < target){
                left1 = mid + 1;
            }else {
                right1 = mid;
            }
        }
        return (nums[left1]==target?left1:-1);
    }
    private int findLastPosition(int[] nums, int target) {
        int left2 = 0, right2 = nums.length - 1;
        while (left2 < right2){
            int mid = (right2 - left2 +1)/2 + left2;
            if (nums[mid] > target){
                right2 = mid - 1;
            }else {
                left2 = mid;
            }
        }
        return (nums[left2]==target?left2:-1);
    }
}
