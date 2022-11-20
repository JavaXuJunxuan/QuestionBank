package 模拟;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */

public class Q541One {
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
//        length始终是一个不变量
        int length = s.length();
        int start = 0;
        while (start < length){
            StringBuffer temp = new StringBuffer();
//            因为题目要求如果这一段中字符少于k个那么全部反转，剩余字符是当前字符到length处字符
            int firstK = (start + k > length) ? length : start + k;
//            这个也同理，不过如果firstK都不足length那么下面的if循环就不执行了也就是secondk没有效果
            int secondK = (start + (2*k) > length) ? length : start + (2*k);
            temp.append(s.substring(start,firstK));
            res.append(temp.reverse());
//            如果不够2k但是比k大也会执行下面if把大于k小于2k的部分加进去然后start+2k导致下次循环进不去而结束
            if (firstK < secondK){
                res.append(s.substring(firstK,secondK));
            }
            start += (2 * k);
        }
        return res.toString();

    }
}
