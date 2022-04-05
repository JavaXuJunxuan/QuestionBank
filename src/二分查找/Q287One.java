package 二分查找;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * 这道题根据抽屉原理，题目的意思翻译就是数组一共N+1个数，但是值都大于1小于n那么想n+1个数都有值，必然至少有一个重复的数
 */

public class Q287One {
    public int findDuplicate(int[] nums) {
//        下面的left，right，mid都是数组[1,N]当中的而不是输入数组中的
        int left = 1, right = nums.length - 1;
        while (left < right){
            int mid = (right - left)/2 + left;
            int count = 0;
//            判断输入数组中小于某个值的个数
            for(int i : nums){
                if (i <= mid){
                    count++;
                }
            }
//            判断个数是否对
//            假设mid取4，那么输入数组规则取数则应该count等于4
//            如果小于等于4的个数小于等于4个那么证明大于4的部分必定有重复的
            if (count <= mid){
                left = mid + 1;
//                如果小于等于4的个数大于4个那么重复的在小于4这个范围
            }else {
                right = mid;
            }
        }
        return left;
    }
}
