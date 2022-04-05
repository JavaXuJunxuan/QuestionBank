package 二分查找;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 * 这是最基本的二分查找，两种方式都可以进行查找因为没有什么限制条件
 */

public class Q704One {
//    public  int search(int[] nums, int target) {
//        int left = 0, right = nums.length-1;
//        while (left < right){
//            int mid = (right - left)/2 + left;
//            if (nums[mid] < target){
//                left = mid + 1;
//            }else {
//                right = mid;
//            }
//        }
//        return nums[left] == target?left:-1;
//    }

    public  int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (right - left + 1)/2 + left;
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return nums[left] == target?left:-1;
    }
}
