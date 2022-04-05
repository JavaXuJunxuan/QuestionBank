package 滑动窗口;


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 */

public class Q1695One {
    public int maximumUniqueSubarray1(int[] nums) {
        int sum = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
//        使用map时不断向map加入元素，重复元素会加入同一个key，那么map的长度不会改变，但是end一直右移，所以end-start+1会不断增加
//        利用这个来判断是否有重复元素，有了就把重复元素剔除然后左指针左移
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int end = 0; end < nums.length; end++){
            if (map.containsKey(nums[end])){
                map.put(nums[end],map.get(nums[end])+1);
            }else {
                map.put(nums[end],1);
                sum += nums[end];
            }
            if (end - start + 1 == map.size()){
                max = Math.max(max,sum);
            }
            while (end - start + 1 > map.size()){
                int headkey = map.keySet().iterator().next();
                int headvalue = map.get(headkey);
                map.remove(headkey);
                map.put(headkey,headvalue - 1);
                if (map.get(headkey) == 0){
                    sum -= headkey;
                    map.remove(headkey);
                }
                start++;
            }
        }
        return max;
    }
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, max = 0, start = 0;
        for (int end = 0; end < nums.length; end++){
            if (!set.contains(nums[end])){
                set.add(nums[end]);
                sum += nums[end];
                max = Math.max(max,sum);
            }else {
//                如果当前遍历的这个元素在set集合中有的话，证明重复了，上面已经移动右指针了，右指针指的就是当前多余的元素
//                下面应该移动左指针，如果当前end元素和start元素不相同时，表明多的元素在start和end下标之间，这里需要
//                把那个多的元素给剔除掉所以遍历集合，知道剔除那个多余的元素，下面不用把sum-去那个多余的元素，因为他的值会被当前的
//                元素给替代掉
                while (nums[end] != nums[start]){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {5,2,1,2,5,2,1,2,5};
        Q1695One q1695One = new Q1695One();
        int i = q1695One.maximumUniqueSubarray(nums);
        System.out.println(i);
    }
}
