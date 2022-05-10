package 暴力解法;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组nums1中。为了应对这种情况，
 *      nums1的初始长度为m+n，其中前m个元素表示应合并的元素，后n个元素为0，应忽略。nums2的长度为 n 。
 */

public class Q88One {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        因为nums1的数组长度是m+n，所以可以直接遍历nums2，然后把nums2的元素加入到nums1中
        for(int i = 0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
