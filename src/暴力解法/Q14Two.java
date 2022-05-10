package 暴力解法;

public class Q14Two {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
//        因为最长公共前缀不可能大于任意一个字符串的长度，所以假设最长公共前缀长度等于第一个字符串的长度
//        所以length是第一个字符串的字符长度
        int length = strs[0].length();
//        count是字符串数组中的总字符串个数
        int count = strs.length;
//        遍历第一个字符串的每一个字符
        for (int i =0; i<length;i++){
//            c是第一个字符串遍历的字符
            char c = strs[0].charAt(i);
//            定义j变量来遍历字符串数组中每一个字符串，一次循环判断一次所有字符串的某一位置字符
//            是否和第一个字符串某一个字符相等
            for (int j =1;j<count;j++){
//                特殊判断：当第一个字符串没有字符时或者
                if(i == strs[j].length() || strs[j].charAt(i) !=c) {
                    return strs[0].substring(0,i);
                }
            }
        }
//        能执行到此处表明字符串数组中所有字符串都相等
        return strs[0];
    }
}
