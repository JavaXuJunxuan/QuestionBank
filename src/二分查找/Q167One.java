package 二分查找;

/**
 * 167的二分查找解法
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

 */

public class Q167One {
        public static int[] twoSum(int[] numbers, int target) {
            for(int i =0;i<numbers.length;i++){
//                这时left就是
                int left=i,right=numbers.length-1;
//                相等时因为left就是i那么right=left导致mid=left=i此时不符合题意退出
                while(left<right){
//                    向上进行取整，防止只有两个数时导致数组出现-1越界
                    int mid=(right-left+1)/2+left;
                    if(numbers[mid]+numbers[i]==target){
                        return new int[]{i+1,mid+1};
                    }else if(numbers[i]+numbers[mid]>target){
//                        即使目标数一直大于数组最后两个数的合也不会越界，因为数组向上取整，一直大于
//                        只会执行left=mid而不是mid+1所以不会越界
                        right=mid-1;
                    }else{
                        left=mid;
                    }
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
