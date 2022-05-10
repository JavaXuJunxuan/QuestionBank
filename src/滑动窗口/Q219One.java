package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class Q219One {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set set = new HashSet();
        int start = 0;
        for (int end = 0; end < nums.length; end++){
            while (end - start > k){
                set.remove(nums[start]);
                start++;
            }
            if (set.contains(nums[end])){
                 return true;
            }
            set.add(nums[end]);
        }
        return false;
    }

    public static void main(String[] args) {
        Q219One q219One = new Q219One();
        int[] ints = {0,1,2,3,2,5};
        q219One.containsNearbyDuplicate(ints,3);
    }
}
