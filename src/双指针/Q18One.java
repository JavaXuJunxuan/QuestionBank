package 双指针;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 这道题和三数之和属于同一种题型
 */

public class Q18One {
    public List<List<Integer>> fourSum(int[] nums, int target) {
//        首先进行返回数组的初始化和特殊判断
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return res;
        }
//        因为要利用数组元素的大小进行双指针遍历，所以需要排序
        Arrays.sort(nums);
        int length = nums.length;
//        遍历第一个元素，因为是四数之和所以第一个元素后还有三个元素，所以要-3
        for (int i = 0; i < length - 3; i++){
//            对遍历的元素进行去重操作
            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            根据当前遍历组合的最大最小值进行优化处理
            long min1 = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) break;
            long max1 = (long)nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) continue;
//            对第一个元素处理完后处理第二个元素，操作同第一个元素
            for (int j = i + 1; j < length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = length - 1;
                long min2 = (long)nums[i] + nums[j] + nums[k] + nums[k + 1];
                if (min2 > target) break;
                long max2 = (long)nums[i] + nums[j] + nums[l] + nums[l - 1];
                if (max2 < target) continue;
//                然后就可以同三数之和一样处理剩下两个元素了，为什么不继续遍历下去呢？
//                因为这最后两个元素一个是当前遍历元素的后一个元素，一个是数组最大下标的元素即一个最小值一个最大值，这两个可以
//                可以进行边界处理，当相遇时退出循环，代表没有符合条件的两个元素
                while (k < l){
                    int cur = nums[i] + nums[j] + nums[k] + nums[l];
                    if (cur == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
//                        找到答案元素后仍要进行去重处理
                        k++;
                        while (k < l && nums[k] == nums[k - 1]){
                            k++;
                        }
                        l--;
                        while (k < l && nums[l] == nums[l + 1]){
                            l--;
                        }
                    }else if (cur < target){
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return res;
    }
}
