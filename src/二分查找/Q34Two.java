package 二分查找;

public class Q34Two {
    public static int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        //这里只要数组中有一个匹配，l和r就不会相等，只要找不到或者压根没有进入循环时这里l和r才会想等。
        return l == r ? new int[] {-1, -1} : new int[] {l, r - 1};
    }
//思路是统一找到左边界，当前target的下一个数的左边界-1就是上一个数的右边界
    private static int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left)/2 + left;
            if (nums[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ints = {5,7,7,8,8,10};
        searchRange(ints,8);
    }
}
