package 双指针;

/**
 * 283.给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 其实和第一个解法一样
 */

public class Q283Three {
    public static void moveZeroes(int[] nums) {
            if(nums==null) {
                return;
            }
            int j=0;
            for (int i =0;i<nums.length;i++){
                if (nums[i]!=0){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j++]=temp;
                }
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
