package 二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 这道题告诉我们，二分查找中可能要找的东西大于数组中所有的数或者小于数组中所有的数，不一定一定在数组中，这是两种不一样的临界情况
 */

public class Q475One {
//    这两个数组中的元素都是一个个位置
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        List<Integer> list = new ArrayList<>();
//        这个循环会遍历每一个房子，其中遍历的元素是每一个房屋的位置，目的是为了找到每一个房屋与加热器的最短距离
        for (int house : houses){
            int left = 0, right = heaters.length - 1;
            while (left < right){
                int mid = (right - left)/2 + left;
//                下面比较的都是位置信息，最短距离就是正好相等时也就是房屋位置处就有供暖气
                if (heaters[mid] < house){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
//          当这道题只有一个供暖期的时候，上面的循环会直接跳过.直接执行下面的条件语句，此时left=0，但是题目中
//            房子第一个元素>=1所以第一次left=0时，不会进入第一个elseif循环，因为加热半径不可能等于0
//            也就是说供暖期只有一个时直接进入条件判断且只可能执行第一个if或者第二个elseif语句
            if (heaters[left] == house){
                list.add(0);
            } else if (heaters[left] < house) {
                // 情况 2：所有的供暖器都在这个房子的左边
                list.add(house - heaters[left]);
            } else if (left == 0) {
                // 情况 3：所有的供暖器都在这个房子的右边
                list.add(heaters[0] - house);
            } else {
                // 情况 4：供暖器位于两个房子之间，取最小者
                list.add(Math.min(heaters[left] - house, house - heaters[left - 1]));
            }
        }
        // 在 res 数组里找最大值
        int ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ans = Math.max(ans, list.get(i));
        }
        return ans;
    }
}

