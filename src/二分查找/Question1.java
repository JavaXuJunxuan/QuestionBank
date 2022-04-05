package 二分查找;

import java.util.Scanner;

public class Question1 {
        public static int search(int[] nums, int target) {
//          low是初始头下标
            int low = 0;
//          high是初始的尾下标
            int high = nums.length - 1;
//          要考虑等于情况：假设数组只有一个数，那么头下标和尾下标都为0那时就会报错
            while (low <= high) {
//              这样写是为了防止出现越界因为high和low可能单个都不会越界但是相加了就有可能越界，所以用减法
                int mid = (high-low)/2+low;
//              定义一个数num等于数组的第一个中间数
                int num = nums[mid];
                if (num==target){
//              当相等时mid即为目标数的下标
                    return mid;
                }else if (num>target){
//              如果第一个中间数比目标数大那么说明目标数在中间数左边，让尾下标左移，并且mid这个数已经不等于目标数了所以减一
                    high=mid-1;
                }else {
//              最后一种情况：中间数比目标数小，说明目标数在中间数右边，头下标右移。
                    low=mid+1;
                }
            }
//          当查找不到时最后头下标会因为-1而比尾下标小或者尾下标+1比头下标大而退出循环，这时返回-1
            return -1;
    }

    public static void main(String[] args) {
            int[] ints={1,15,24,36,40,57,59,64,73};
            int index = search(ints,64);
            System.out.println(index);
    }
}

