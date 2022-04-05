package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class Q1Two {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<Integer,Integer>();
        for (int i =0;i<nums.length;i++){
//            这里为什么用containskey，因为哈希表中value存的是数组下标，为什么存下标？
//            我认为有两点，第一是题目要求最后返回值是数组的下标
//            第二点是因为数组中很可能有相同的元素，但是他们下标不一样，一定有先有后，
//            前面的元素遍历完到后面出现相同时会存入哈希表的链表部分，因为一样所以会覆盖
//            减小数组压力
            if (hashtable.containsKey(target-nums[i])){
                return new int[]{
                        hashtable.get(target-nums[i]),i
                };
            }
//            为什么增加操作放在if后，因为当target=2*nus[0]时会出错
//            这样放可以保证i的下标一直比hashmap最后一个元素的下标大一，排除了返回两个同一坐标的错误
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}
