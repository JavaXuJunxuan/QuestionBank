package 排序;

import java.util.Arrays;

/*    插入排序（Insertion-Sort） 的算法描述是一种简单直观的排序算法。
它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，
需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 */
public class InsertionSort {
    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        int current, next;
        //从数组第一个元素开始, 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        //循环不变量为nums[0, i + 1）,初始化时（循环没开始）i=0，区间[0,1)有一个元素，所以有序
        //循环中，我们每次都操作i后面一个元素，所以也可以保证[0，i + 1）有序即[0，i + 1]，然后i++，即把nums[i + 1]插入区间
        //nums[0，i+1)使得nums[0,i + 1]有序，这样下次循环开始前也保持了性质
        //结束时nums[0，length - 1 + 1=length]有序
//        每一次循环排定的元素都是next即i+1位置的元素，那么每次待插入的位置也是next，
//        插入排序是把next插入到它该在的位置，小了就往前面不断遍历然后插
//        如果当前待排序位置next不是最小的，那么就需要向前遍历找到它的位置
        for (int i = 0; i < array.length - 1; i++) {
            //这里默认当前遍历的元素已经排序好了，比如数组下标为0的元素就不需要进行移动了，我们只需要比较当前遍历元素的
            //后一个元素与这个元素之前元素的大小关系即可。因为这里会移动当前正在遍历的这个元素，所以先把这个元素（i+1）的元素值保存起来
            current = i;
            //比较当前遍历的元素和i+1这个下标元素的大小，直到找到这个元素应该存放的位置
            next = array[i + 1];
            //每次循环时当前遍历元素的后一位相当于都是空着的，因为我们已经使用了next保存了它的值。
            //插入排序和希尔排序遍历的都是当前元素，把当前元素的后一个元素即这次循环需要排序的元素保持不变
            while(current >= 0 && next < array[current]){
                array[current + 1] = array[current];
                current--;
            }
            array[current + 1] = next;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] res = InsertionSort.insertionSort(nums);
        System.out.println(Arrays.toString(res));
    }
}
