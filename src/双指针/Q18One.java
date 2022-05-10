package 双指针;

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
 */

public class Q18One {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int k = 0; k < length - 3; k++){
            if (k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            long min1 = (long)nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target){
                break;
            }
            long max1 = (long)nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target){
                continue;
            }
            for (int i = k + 1; i < length - 2; i++){
                if (i > k + 1 && nums[i] == nums[i - 1]){
                    continue;
                }
                int j = i + 1;
                int h = length - 1;
                long min2 = (long)nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min2 > target){
                    break;
                }
                int max2 = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max2 < target){
                    continue;
                }
                while ( j < h){
                    int cur = nums[k] + nums[i] + nums[j] + nums[h];
                    if (cur == target){
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]){
                            j++;
                        }
                        h--;
                        while (j < h && nums[h] == nums[h + 1]){
                            h--;
                        }
                    }else if(cur < target){
                        j++;
                    }else {
                        h--;
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum1(int[] nums, int target) {

    }
}
