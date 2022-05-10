package 滑动窗口;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 */

public class Q220One {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<Long>();
        int start = 0;
        for (int end = 0; end < nums.length; end++){
            if (end - start > k){
                treeSet.remove(nums[start] * 1L);
                start++;
            }
//            每次查找的时候nums[end]都是符合要求的，在正确的窗口范围内，找不到就把它放进set中，然后进入下一次查找
            Long u = nums[end] * 1L;
            Long l = treeSet.floor(u);
            Long r = treeSet.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            treeSet.add(u);
        }
        return false;
    }
    public static void main(String[] args) {
        Q220One q219One = new Q220One();
        int[] ints = {1,5,9,1,5,9};
        q219One.containsNearbyAlmostDuplicate(ints,2,3);
    }
}
