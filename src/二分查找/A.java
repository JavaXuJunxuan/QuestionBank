package 二分查找;

public class A {
    // 查找第一个值等于给定值的元素
    private int firstEquals(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (right - left)/2 + left;
            if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return -1;
    }
    // 查找最后一个值等于给定值的元素
    private int lastEquals(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (right - left + 1)/2 + left;
            if (arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return -1;
    }
    // 查找第一个大于等于给定值的元素
    private int firstLargeOrEquals(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (right - left)/2 + left;
            if (arr[mid] > target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
