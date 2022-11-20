package 双指针;

/*剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。*/
public class J21_1One {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            while (left < right && nums[left] % 2 != 0) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
    public int[] exchange1(int[] nums) {
        int slow = 0, fast = 0, temp;
        while (fast < nums.length){
            if ((nums[fast] & 1) == 1){
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
            }
            fast++;
        }
        return nums;
    }
}
