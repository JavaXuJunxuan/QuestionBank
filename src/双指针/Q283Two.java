package 双指针;

/**
 * 283.给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

public class Q283Two {
//    这个解法是i右指针不断向右遍历只要找到不为0的数就把它提前到j的下标位置，是替换而不是交换
    public static void moveZeroes(int[] nums) {
       int j = 0;
       for (int i = 0;i<nums.length;i++){
           if (nums[i]!=0){
               nums[j++]=nums[i];
           }
       }
       for (int i =j;i< nums.length;i++){
           nums[i]=0;
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
