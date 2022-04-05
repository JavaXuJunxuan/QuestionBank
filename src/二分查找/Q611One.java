package 二分查找;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */

public class Q611One {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1, right = nums.length;
                while (left < right) {
                    int mid = (right + left) / 2;
                    int sum = nums[i] + nums[j];
                    if (nums[mid] < sum) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += (left - j - 1);
            }
        }
        return count;
    }
}
