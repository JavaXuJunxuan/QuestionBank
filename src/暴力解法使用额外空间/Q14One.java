package 暴力解法使用额外空间;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */

public class Q14One {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
//        假设字符串数组中第一个字符串即为最大公共前缀
        String prefix = strs[0];
        int count = strs.length;
        for (int i =1;i<count;i++){
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length()==0){
                break;
            }
        }
        return prefix;
    }
//    这个方法的目的是查找两个字符串的最大公共前缀
    public String longestCommonPrefix(String s1 ,String s2){
//        这两个字符串的最大公共前缀一定小于等于这两个字符串中的最小长度
        int length = Math.min(s1.length(),s2.length());
//        定义一个不断向右移动的指针
        int index = 0;
//        迭代比较两个字符串的每个字符，直到遍历完或者两个字符串中某一个下标位置字符不相等
        while (index < length && s1.charAt(index) == s2.charAt(index)){
            index++;
        }
//        substring方法返回的是一个前闭后开的区间
        return s1.substring(0,index);
    }
}
