package 滑动窗口;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 这道题考的是排列是子串，所以只要s1中的字符个数等于s2中一个子串的字符个数即可
 * 所以可以用滑动窗口法，这个窗口长度为s1的字符长度
 */

public class Q567One {
    public boolean checkInclusion1(String s1, String s2) {
        int n = s1.length(),m = s2.length();
        if(n>m){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i =0;i<n;i++){
//          因为字符和字符做运算是字符的ASCll码做运算，所以s1.charAt(i) - 'a'最后一个数
//          count1[s1.charAt(i) - 'a']表示数组中一个元素
//          这一循环主要是统计两个字符串中各个字符的个数
            ++count1[s1.charAt(i) - 'a'];
            ++count2[s2.charAt(i) - 'a'];
        }
//      n是s1的字符串长度，这个if条件判断的是s2前n个字符是否和s1相等或者s2等于s1
        if (Arrays.equals(count1,count2)){
            return true;
        }
//      进入下面这个循环表示s2不等于s1且s2前n个字符中各个字符的个数不等于s1各个字符的个数
        for (int i =n;i<m;i++){
//            不断向右移动这个长度为n的滑动窗口
            ++count2[s2.charAt(i)-'a'];
            --count2[s2.charAt(i-n)-'a'];
//            每次移动后都有可能导致s2的子串等于s1的排列，所以每次都需要判断一下
            if (Arrays.equals(count1,count2)){
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
//      因为要统计每个字符的数量，所以使用大小为26的数组
        int[] ints1 = new int[26];
        int[] ints2 = new int[26];
//      统计答案字符串的字符数
        for (int i = 0; i < length1; i++){
            ints1[s1.charAt(i) - 'a']++;
        }
        int start = 0;
//      遍历目标字符串，这里循环每次开始时窗口区间的长度一定小于等于答案字符串的长度
        for (int end = 0; end < length2; end++){
            ints2[s2.charAt(end) - 'a']++;
//          当窗口区间长度大于答案字符串长度时就要右移左指针使之等于答案字符串的长度，因为题目要找子串
            while (end - start + 1 > length1){
                ints2[s2.charAt(start)-'a']--;
                start++;
            }
//          当长度相等时就比较两个数组是否相等,相等就代表数组中各个字符数都相等就找到了那个子串
            if (end - start + 1 == length1){
                if (Arrays.equals(ints1,ints2))return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q567One q567One = new Q567One();
        String s1 = "ab";
        String s2 = "eidbaooo";
        q567One.checkInclusion1(s1,s2);
    }
}
