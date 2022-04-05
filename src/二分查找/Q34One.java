package 二分查找;

import jdk.nashorn.internal.ir.IfNode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */

public class Q34One {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        int firstPosition = findFirstPosition(nums,target);
//        如果数组中第一个等于target的元素都没有，表示数组中没有等于target的元素直接返回int[]{-1,-1}即可
        if (firstPosition == -1){
            return new int[]{-1,-1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition,lastPosition};
    }

    private int findFirstPosition(int[] nums, int target) {
        int left1 = 0, right1 = nums.length - 1;
        while (left1 < right1){
            int mid = (right1 - left1)/2 + left1;
//            如果中间值小于目标值那么中间值左边一定都不是，只有保证一边一定都不是才可以移动左指针
            if (nums[mid] < target){
                left1 = mid + 1;
//                else表示中间值大于等于目标值，也许这个就等于目标值，也许前一个就等于目标值把右边界收缩
//                但是这里不能用中间值小于等于目标值让left=mid（下面的代码）因为此时这个中间值可能就等于目标值，
//                而且中间值旁边的元素都等于目标值，把left = mid会让元素第一个下标被错过掉
            }else {
                right1 = mid;
            }
            /*if (nums[mid] > target){
                right = mid -1;
            }else {
                left = mid;
            }*/
        }
        return (nums[left1]==target?left1:-1);
    }

    private int findLastPosition(int[] nums, int target) {
        int left2 = 0, right2 = nums.length - 1;
        while (left2 < right2){
            int mid = (right2 - left2 +1)/2 + left2;
//            如果中间值小于目标值那么中间值左边一定都不是，只有保证一边一定都不是才可以移动左指针
            if (nums[mid] > target){
                right2 = mid - 1;
//                else表示中间值大于等于目标值，也许这个就等于目标值，也许前一个就等于目标值把右边界收缩
//                但是这里不能用中间值小于等于目标值让left=mid（下面的代码）因为此时这个中间值可能就等于目标值，
//                而且中间值旁边的元素都等于目标值，把left = mid会让元素第一个下标被错过掉
            }else {
                left2 = mid;
            }
            /*if (nums[mid] > target){
                right = mid -1;
            }else {
                left = mid;
            }*/
        }
        return (nums[left2]==target?left2:-1);
    }
}
