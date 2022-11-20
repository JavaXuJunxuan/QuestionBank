package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

public class Q169One {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxNum = 0, maxCount = 0;
        for (int num : nums){
            int count = map.getOrDefault(num,0) + 1;
            map.put(num,count);
            if (count > maxCount){
                maxCount = count;
                maxNum = num;
            }
;        }
        return maxNum;
    }
}
