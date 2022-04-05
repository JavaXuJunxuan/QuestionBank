package 二分查找;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */

public class Q33One {
    public int search(int[] nums, int target) {
        int min = Integer.MAX_VALUE, index = -1, result = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < min){
                min = nums[i];
                index = i;
            }
        }
        int left1 = 0, right1 = index - 1;
        while (left1 < right1){
            int mid = (right1 - left1)/2 + left1;
            if (nums[mid] < target){
                left1 = mid + 1;
            }else{
                right1 = mid;
            }
        }
        if (nums[left1] == target){
            return left1;
        }
        int left2 = index, right2 = nums.length -1;
        while (left2 < right2){
            int mid = (right2 - left2)/2 + left2;
            if (nums[mid] < target){
                left2 = mid + 1;
            }else{
                right2 = mid;
            }
        }
        return nums[left2] == target?left2:result;
    }

//    这种解法是通过条件来使得旋转排序数组二分查找时为有序数组
    /*public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (right - left)/2 + left;
//            这里是等于的情况
            if (nums[mid] == target) {
                return mid;
            }
//            中间值在右侧
            if (nums[mid] < nums[0]){
//                目标值在中间值和右指针之间
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
//              执行else语句表示target一定比中间值小，因为相等会退出大于会执行上面的语句
                }else {
                    right = mid - 1;
                }
//            中间值在左侧包含等于nums【0】的情况，等于也表示在左侧
            }else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }*/
}
