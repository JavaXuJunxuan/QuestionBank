package 二分查找;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1和nums2，返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序。
 */
public class Q349One {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++){
            int target = nums1[i];
            int left = 0, right = nums2.length -1;
            while (left < right){
                int mid = (right - left)/2 + left;
                if (nums2[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if (nums2[left] == target){
                set.add(nums2[left]);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set){
            result[index++] = i;
        }
        return result;
    }
}
