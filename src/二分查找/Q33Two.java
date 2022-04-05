package 二分查找;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */

public class Q33Two {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target? 0:-1;
//      找到临界点，为下面的二分查找做准备
        int left = 0, right = n - 1;
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
//        在右半段时：
        if (target < nums[0]){
            left = left + 1;
            right = n - 1;
//        在左半段时：
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
//        写成return nums[l] == target ? l会越界
//        因为第一次二分是向上取整的mid，可能已经是数组最后一个数了，而在第二次二分开始时赋值l=l（上一次二分赋值了mid）+1所以会越界
        return nums[right] == target ? right : -1;
    }
}
