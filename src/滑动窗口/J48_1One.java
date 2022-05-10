package 滑动窗口;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */

public class J48_1One {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int start = 0, max = 0;
        for (int end = 0; end < s.length(); end++){
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
            }else {
                while (s.charAt(end) != s.charAt(start)){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        J48_1One s = new J48_1One();
        String s1 = "tmmzuxt";
        s.lengthOfLongestSubstring(s1);
    }
}
