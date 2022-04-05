package 暴力解法使用额外空间;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 此为暴力解法，使用额外数组空间
 */

public class Q577One {
        //利用三个指针。解决
        public String reverseWords(String s) {
            //定义一个可变字符串，来存储字符串，原因字符串String是不可变的
            StringBuffer res = new StringBuffer();
            //字符串的长度
            int length = s.length();
            //定义一个遍历字符串的指针
            int i = 0;
            while (i < length) {
                //定义一个存储每个空格后，下一个单词的起始位置下标
                int start = i;
                //遍历字符串，只要碰不到空格，就一直移动 i 指针
                while (i < length && s.charAt(i) != ' ') {
                    i++;
                }
                //代码执行到这里表示此时已经遇到空格，此时i的下标指向遍历的最后一个单词后的空格位置下标
                //在定义一个tail指针，用来指向最后遍历的这个单词的起始位置
                for (int tail = start; tail < i; tail++) {
                    //将单词逐个添加，不过是先添加最后一个字符
                    //这里为什么要加start，是因为这里要执行代码是为了加一个新单词，为了使
                    //新加入的单词在前一个单词之后，需要这个新单词的头下标（start因为
                    //20行代码表示start是这个新单词的起始位置下标
                    //此时的i指向的是这个新单词后的空格下标所以-1
                    //（i-1）-start表示这个新单词遍历的最后一个字符下标
                    res.append(s.charAt(start + i - 1 - tail));
                }
                //这是将单词后的空格加上
                while (i < length && s.charAt(i) == ' ') {
                    i++;
                    res.append(" ");
                }
            }
            return res.toString();
        }
}

