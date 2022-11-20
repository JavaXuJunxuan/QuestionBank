package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */

public class Q217One {
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for(int i : nums){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
