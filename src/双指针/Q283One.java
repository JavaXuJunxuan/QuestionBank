package 双指针;

/**
 * 283.给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

public class Q283One {
    public static void moveZeroes(int[] nums) {
        int n = nums.length,left=0,right=0;
        while (right<n){
            if (nums[right]!=0){
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args){
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        for (int anInt : ints) {
            System.out.print(anInt + "\t");
        }
    }
}
