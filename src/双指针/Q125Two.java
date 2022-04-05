package 双指针;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */

public class Q125Two {
    public boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++){
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stringBuffer.append(Character.toLowerCase(ch));
            }
        }
        int n = stringBuffer.length();
        int left = 0, right = n - 1;
        while (left < right){
            if (Character.toLowerCase(stringBuffer.charAt(left)) != Character.toLowerCase(stringBuffer.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
