package 双指针;

/**
 * 977.解法一
 */

public class Q977One {
        public static int[] sortedSquares(int[] nums) {
//            n为传入数组的长度
            int n = nums.length;
//            定义分界值初始为-1
            int negative = -1;
//            循环找到数组中的临界下标
            for (int i = 0;i < n;i++){
                if (nums[i]<0){
                    negative = i;
                }else {
                    break;
                }
            }
//            定义一个新数组,长度和传入数组长度一致
            int[] ans = new int[n];
//            定义一个头下标,i是上面循环中找到的临界下标
            int index = 0,i=negative,j = negative+1;
//            如果临界下标大于等于0或者临界下标加1比数组长度小因为要保证不会越界
            while (i >= 0 || j < n) {
//                如果临界下标小于0代表数组中没有负数
                if (i < 0) {
//                    新数组的头下标位置的数等于传入数组中的0位置的元素的平方
                    ans[index] = nums[j] * nums[j];
//                    且数组下标自增保证取到数组中的全部元素
                    ++j;
//                    j==n代表临界下标等于数组尾坐标,意思是传入的数组中全是负数
                } else if (j == n) {
//                    这时i的取值(临界下标为传入数组的尾坐标)
                    ans[index] = nums[i] * nums[i];
                    --i;
//                    当不属于以上两种情况时表示临界下标在中间，则开始比较双指针所指向的元素，这时双指针在中间，向两边走
//                    当右指针所指向的元素的平方比左指针指向的元素的平方大时
                } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
//                    把左指针指向的元素的平方放入新数组的头下标位置，因为传入得数组是非递减数组，所以如果有负数，取平方后
//                    中间的数最小，最大值出现在两边
                    ans[index] = nums[i] * nums[i];
//                    然后右指针不动，因为所指向的元素还没有放入新数组中，所以左指针自减
                    --i;
                } else {
//                    跟上面的相反
                    ans[index] = nums[j] * nums[j];
                    ++j;
                }
//                因为每做一次循环都会往新数组中放入一个数所以需要自增
                ++index;
            }
//            返回新数组
            return ans;
    }

    public static void main(String[] args) {
        int[] ints = {-70,-24,-14,-9,-7,-7,-6,-3,-1,0,5,9,14,14,65,97};
        int[] ints1 = sortedSquares(ints);
        for (int i : ints1){
            System.out.println(i);
        }
    }
}
