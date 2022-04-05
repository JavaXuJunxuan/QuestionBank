package 字符串;

public class Q67Two {
    public static String addBinary1(String a, String b) {
//        定义一个可变长的字符串，因为下面每次进行一次位运算都要向字符串中加字符
        StringBuffer ans = new StringBuffer();
//        找出两个字符串中最长的那个字符串的长度，方便下面将较短的那个字符串进行补0操作，carry是进位变量
        int n = Math.max(a.length(),b.length()),carry=0;
//        遍历长度为最长字符串的长度
        for (int i = 0;i < n;i++){
//            下面的代码中=最后进行运算，因为=优先级最低
//            遍历字符串为从最小位（大下标）进行遍历，所以最后需要进行反转数组
//            为什么要 - ‘0’？
//            因为字符型是由ASCII码表示的，与数字对对应不上，减去'0'之后，刚好字符之间与数字之间可以对应；
//            比如：char c1 = '1' + '1' - '0'; （'1'的ASCII为49，'0'为48） 这样结果才能变成'2';
//            否则如果不减去'0',结果就是两个字符1之间的ASCII相加，为98
//            PS:String.charAt返回的char类型值为ASCII码
//            所以a.charAt(a.length() - 1 - i)结果为ASCII码，-‘0’也是对应的ASCII码进行运算
            carry += i < a.length()?(a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length()?(b.charAt(b.length() - 1 - i) - '0') : 0;
//            这里的carry % 2运算出来的是数字int类型，因为上面定义的carry是int，要么为1要么为0
            ans.append((char)(carry % 2 + '0'));
//            这里carry为下一位上的进位数
            carry /= 2;
        }
//        出循环了判断进位变量carry是否为0，如果不=0则需要再在字符串最前面进位
        if (carry > 0){
            ans.append('1');
        }
//        因为上面字符串从最小位遍历，放的位置正好是新字符串最前面所以需要反转
        ans.reverse();
        return ans.toString();
    }
    public String addBinary2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
//        carry是进位变量
        int carry = 0;
//        定义一个可变字符串来储存相加后的字符串
        StringBuilder builder = new StringBuilder();
//        遍历相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0){
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
//        这里如果a字符串还没有遍历完（a串比b串长），则继续遍历a串的剩余部分
        while (i >= 0){
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
//       这里如果b字符串还没有遍历完（b串比a串长），则继续遍历b串的剩余部分
        while (i >= 0){
            int sum = carry + b.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
//        完全遍历完后，如果carry还有值需要进位补充进去
        if (carry != 0){
            builder.append(carry);
        }
//        最后反转字符串并化为String类型返回
        return builder.reverse().toString();
    }
}
