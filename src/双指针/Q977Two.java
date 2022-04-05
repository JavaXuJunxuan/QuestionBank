package 双指针;

/**
 * 977.解法二
 */

public class Q977Two {
        public static int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
//            tail是新数组尾坐标,i是原数组偷坐标，j是元素组尾坐标
//            为什么可以从两边同时遍历原数组的元素的平方，因为本题是非递减数组，最大值一定出现在两边
            for (int i = 0, j = n - 1, tail = n - 1; i <= j;) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    ans[tail] = nums[i] * nums[i];
                    ++i;
                } else {
                    ans[tail] = nums[j] * nums[j];
                    --j;
                }
                --tail;
            }
            return ans;
        }
    public static void main(String[] args) {
        int[] ints = {-70,-24,-9,-7,-7,-6,-3,-1,0,5,9,14,14,65,97};
        int[] ints1 = sortedSquares(ints);
        for (int i : ints1){
            System.out.println(i);
        }
    }
}
