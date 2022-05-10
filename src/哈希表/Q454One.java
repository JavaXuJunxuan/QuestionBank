package 哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */

public class Q454One {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        for (int i : nums1){
            for (int j : nums2){
                temp = i + j;
                if (map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                }else {
                    map.put(temp,1);
                }
            }
        }
        for (int i : nums3){
            for (int j : nums4){
                temp = i + j;
                if (map.containsKey(0 - temp)){
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
