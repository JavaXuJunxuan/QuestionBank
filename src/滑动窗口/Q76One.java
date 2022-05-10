package 滑动窗口;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */

public class Q76One {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }
        int min = Integer.MAX_VALUE, length = t.length(), start = 0, index = 0;
        for (int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if (need[c] > 0){
                length--;
            }
            need[c]--;
            if (length == 0){
                while (need[s.charAt(start)] < 0){
                    start++;
                    need[s.charAt(start)]++;
                }
                min = Math.min(min, end - start + 1);
                if (min == end - start + 1) index = start;
                need[s.charAt(start)]++;
                start++;
                length++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);
    }
}