package 双指针;

import java.util.Calendar;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */

public class J05_1Two {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                stringBuilder.append("  ");
            }
        }
        if (stringBuilder.length() == 0){
            return s;
        }
        int left = s.length() - 1;
        s += stringBuilder.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0){
            if (chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
    public String replaceSpace1(String s){
        if (s == null || s.length() == 0){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == ' '){
//                这里只需要添加两个空格即可，因为原来的空格也会利用到
                stringBuilder.append("  ");
            }
        }
        if (stringBuilder.length() == 0){
            return s;
        }
        int left = s.length() - 1;
        s = s + stringBuilder.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0){
            if (chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
//              这里没有进行--，不然else中也要进行--
                chars[right] = '%';
            }else {
                chars[right] = chars[left];
            }
            right--;
            left--;
        }
//        这里不能直接chars.toString()，否则输出的是其地址，因为Char数组的toString方法没有重写
        return new String(chars);
    }
}
