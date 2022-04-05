package 二分查找;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 */

public class Q744One {
    public char nextGreatestLetter(char[] letters, char target) {
        /*int left = 0, right = letters.length;
        while (left < right){
            int mid = (right - left)/2 + left;
            if (letters[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (left == letters.length){
            return letters[0];
        }
        if (target != letters[left]){
            return letters[left];
        }
        while (target == letters[left]){
            if (left == letters.length - 1){
                return letters[0];
            }
            left++;
        }
        return letters[left];*/


        int len = letters.length;
        // 转换为第 35 题：其实就是找插入元素的位置
        // 搜索范围 [0, len]
        int left = 0;
        // 分析这一步特别重要
        int right = len;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (letters[mid] <= target){
                // 下一轮搜索的区间是：[mid + 1, right]
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        // 因为有可能不存在
        if (left == len){
            return letters[0];
        }
        return letters[left];
    }
}
