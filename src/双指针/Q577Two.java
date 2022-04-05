package 双指针;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 此为双指针解法
 */

public class Q577Two {
        public static String reverseWords(String s) {
            //因为字符串不可变，所以必须定义一个可变的字符串来存储新的字符
            StringBuilder ans = new StringBuilder();
            //遍历原字符串，取出单个单词，以空格分开
            for(String str: s.trim().split(" ")){
                //将取出的单词，转化为字符数组的形式
                char[] chars = str.toCharArray();
                //反转单词
                reverseString(chars);
                //将反转后的单词，追加到新的可变字符串中，并加上空格
                ans.append(chars).append(" ");
            }
            //将字符数组转为字符串形式输出，并删除头尾的空格
            //因为在追加最后一个字符的时候，末尾会有一个空格
            return ans.toString().trim();
        }
        public static void reverseString(char[] chars){
            //左指针，指向头部
            int left = 0;
            //右指针，指向尾部
            int right= chars.length-1;
            //只要左指针小于右指针，就交换两个字符
            while(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                //两个指针同时移动
                left++;
                right--;
            }
        }
    public static void main(String[] args) {
        String s = " hello world i am xjx";
        System.out.println(reverseWords(s));
    }
}
