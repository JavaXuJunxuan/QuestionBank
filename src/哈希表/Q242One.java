package 哈希表;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */

public class Q242One {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++){
            ints[s.charAt(i) - 'a']++;
            ints[t.charAt(i) - 'a']--;
        }
        for (int i : ints){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
