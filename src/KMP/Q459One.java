package KMP;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */

public class Q459One {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;
        int len = s.length();
//        定义哨兵
        s = " " + s;
        char[] chars = s.toCharArray();
//        定义next数组
        int[] next = new int[chars.length];
//        构造next数组
        for (int j = 0, i = 2; i <= len; i++){
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            if (chars[i] == chars[j + 1]) j++;
            next[i] = j;
        }
        if (next[len] > 0 && len % (len - next[len]) == 0){
            return true;
        }
        return false;
    }
}
