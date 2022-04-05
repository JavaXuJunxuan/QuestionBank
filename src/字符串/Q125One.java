package 字符串;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */

public class Q125One {
    public boolean isPalindrome(String s) {
//        新建一个可变长字符串用来存储传入字符串中的数字和字母
        StringBuffer stringBuffer = new StringBuffer();
//        遍历字符串
        int length = s.length();
        for (int i = 0; i < length; i++){
//            取出当前遍历字符串的字符
            char ch = s.charAt(i);
//            下面这个方法是用来判断这个字符是否是一个数字或者字母
            if (Character.isLetterOrDigit(ch)){
//                题目忽略大小写所以统一把字符转换为小写
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
//        比较是否是回文串只需要将原字符串反转一下然后判断是否相等即可
        StringBuffer stringBuffer1 = new StringBuffer(stringBuffer).reverse();
        return stringBuffer.toString().equals(stringBuffer1.toString());
    }
}
