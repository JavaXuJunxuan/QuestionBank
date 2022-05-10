package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */

public class Q349Two {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> target = new HashSet();
        Set<Integer> resSet = new HashSet();
        for (int i = 0; i < nums1.length; i++){
            target.add(nums1[i]);
        }
        for (int i : nums2){
            if (target.contains(i)){
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index = 0;
        for (int i :resSet){
            resArr[index++] = i;
        }
        return resArr;
    }
}
