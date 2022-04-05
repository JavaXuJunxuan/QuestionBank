package 双指针;

/**
 * 167的双指针解法
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

 */

public class Q167Two {
    public static int[] twoSum(int[] numbers, int target) {
        int left=0,right= numbers.length-1;
        while (left<right){
            if (numbers[left]+numbers[right]==target){
                return new int[]{left+1,right+1};
            }else if (numbers[left]+numbers[right]<target){
                left++;
//                这里的else表示numbers[left]+numbers[right]>target因为等于上面已经判断过了
            }else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args){
        int[] ints = {3,24,50,79,88,150,345};
        int[] ints1 = twoSum(ints,200);
        for (int anInt : ints1) {
            System.out.print(anInt + "\t");
        }
    }
}
