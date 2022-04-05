package 二分查找;

/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 你必须尽可能减少整个操作步骤。
 */

public class Q81One {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        // 恢复二段性，因为题目中数组的元素可能有重复的，旋转点可能在一堆相同的元素中，会把相同的元素进行旋转，导致右半部分有跟
//        旋转后的0下标元素相同的元素，此时二段性消失，无法通过二分找到旋转点
//        极端情况可能数组全部为一个元素，此时可能会right=-1所以需要right>left
        while (left < right && nums[0] == nums[right]) right--;
//      找到临界点，为下面的二分查找做准备
        while (left < right){
            int mid = (right - left + 1)/2 + left;
//            最后临界条件是取到数组中最大的那个元素的下标，它下一个元素为旋转前下标为0的元素
            if (nums[mid] < nums[0]){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
//        上面的循环退出时left=right=最大元素的下标
//        判断目标值在数组左半段还是右半段?
//        在左半段时：
        if (target < nums[0]){
            left = left + 1;
            right = n - 1;
//        在右半段时：
        }else {
            left = 0;
        }
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right] == target ? true : false;
    }
}
