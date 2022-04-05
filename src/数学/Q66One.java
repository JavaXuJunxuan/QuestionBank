package 数学;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

public class Q66One {
    public int[] plusOne(int[] digits) {
//        定义变量为数组长度
        int n = digits.length;
//        编写一个循环，倒序遍历数组，找到第一个不为9的元素下标
        for (int i = n-1; i >=0; i--){
//            只要不等于9就进入这个循环
            if (digits[i] != 9){
//                将这个元素值+1
                digits[i]++;
//                这个元素后面的元素全部为9，所以需要将其变为0
                for (int j = i + 1;j < n; j++){
                    digits[j] = 0;
                }
//                因为题目要求末尾数字加1，所以只要这个数组中有不为9的元素，就执行题目要求的操作，然后直接返回即可
                return digits;
            }
        }
        int[] arr = new int[n+1];
//        数字数组默认元素值是0
        arr[0] = 1;
        return arr;
    }
}
