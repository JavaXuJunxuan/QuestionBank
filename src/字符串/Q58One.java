package 字符串;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */

public class Q58One {
    public int lengthOfLastWord(String s) {
//        首先定义一个下标表示字符串的最后一个字符
        int index = s.length() - 1;
//        这一步是为了防止最后若干位位是空格
        while (s.charAt(index) == ' '){
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' '){
            wordLength++;
            index--;
        }
        return wordLength;
    }
}
