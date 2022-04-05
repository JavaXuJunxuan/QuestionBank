package 双指针;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 此题因为需要删除元素，所以修改后的数组一定比之前的数组长度短，采用双指针把输出数组写在输入数组上
 */

public class Q27One {
    public int removeElement(int[] nums, int val) {
        int left=0;
//        这里可以用把右指针当成遍历的参数，因为需要把数组完整遍历一遍，且右指针遍历完一个元素不需要进行任何操作
        for (int right =0;right<nums.length;right++){
            if(nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }
    public int removeElementImprove(int[] nums, int val) {
        int left=0,right=nums.length-1;
//        这里为什么是=号？
//        因为当下面循环赋值时如果左指针当前位置val则会进入if进行赋值右指针元素,此时right左移
//        那么赋值完了下一次会进入else循环此时left右移,此次赋值工移动了两个单位,会导致left=right时出现在同一个未遍历的元素上
        while (left<=right){
//            这个算法一直判断左指针所在位置的元素是否和val相同，可以避免需要保留的元素的重复赋值操作
            if (nums[left]==val){
                nums[left]=nums[right];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
