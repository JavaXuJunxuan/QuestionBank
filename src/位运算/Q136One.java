package 位运算;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */

public class Q136One {
    public int singleNumber(int[] nums) {
//        定义一个0用来进行位运算，任何数和 00 做异或运算，结果仍然是原来的数，即 a⊕0=a。
        int single = 0;
        for (int num : nums) {
//                    第一次遍历后single的值等于第一个数
            single ^= num;
        }
//                遍历到最后剩下没有化掉的值就是出现一次的数
        return single;
    }
}
