package 暴力解法;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 */

public class Q28One {
    public int strStr(String haystack, String needle) {
//        首先取出两个字符串长度
        int n = haystack.length(),m = needle.length();
//        因为是匹配子字符串，所以遍历父串时不能超过父串的长度，所以i+m<=n
        for (int i = 0;i+m<=n;i++){
//            定义一个结果参数
            boolean flag = true;
//            遍历字符串看是否父串中是否有匹配的字符串子串
            for (int j = 0;j<m;j++){
//                只要父串中有一个不等于子串那么退出循环
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
//            每一次遍历完后都判断结果参数是否为true
            if (flag){
//                为true则返回此时父串的下标
                return i;
            }
        }
//        遍历完父串后if条件都不符合时表示父串没有匹配的子串，返回-1
        return -1;
    }
}
