package 滑动窗口;

import java.util.logging.Level;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */

public class Q718One {
    public int findLength(int[] nums1, int[] nums2) {
        return nums1.length <= nums2.length? findMax(nums1, nums2) : findMax(nums2, nums1);
    }
    public int findMax(int[] nums1, int[] nums2){
        int max = 0;
        int m = nums1.length, n = nums2.length;
        for (int len = 1; len <= m; len++){
            max = Math.max(max,maxLen(nums1, 0, nums2, n - len, len));
        }
        for (int j = n - m; j >= 0; j--){
            max = Math.max(max, maxLen(nums1, 0, nums2, j, m));
        }
        for (int i = 1; i < m; i++){
            max = Math.max(max,maxLen(nums1, i, nums2, 0, m - i));
        }
        return max;
    }
    public int maxLen(int[] nums1, int i, int[] nums2, int j, int len){
        int count = 0, res = 0;
        for (int k = 0; k < len; k++){
            if (nums1[i + k] == nums2[j + k]){
                count++;
            }else if(count > 0){
                res = Math.max(count,res);
                count = 0;
            }
        }
        return count > 0? Math.max(count,res) : res;
    }
}
