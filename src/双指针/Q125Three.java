package 双指针;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */

public class Q125Three {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
//        遍历字符串知道left和right遇到一个数字或者字母
        while (left < right){
//            当遍历到的不是字母或者数字则进入循环，是则退出
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
//            遍历为两个字母或者数字后进入判断
            if (left < right){
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
