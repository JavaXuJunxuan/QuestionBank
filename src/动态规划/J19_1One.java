package 动态规划;

/*剑指 Offer 19. 正则表达式匹配
请实现一个函数用来匹配包含'. '和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。*/
public class J19_1One {
    public boolean isMatch(String s, String p) {
        //遍历字符串用
        int n = s.length();
        int m = p.length();
        //每一次匹配的结果状态，这里定义为n+1目的是最前面留有一个空串
        boolean[][] f = new boolean[n + 1][m + 1];
        //遍历主串，然后对每一种可能的正则匹配串进行判断，得出状态值，不断递推得到最后的结果
        for (int i = 0; i <= n; i++){
            //每次都匹配主串的一个字符，然后由这个字符结果推下一个字符，且当前匹配串字符的结果都是由主串的前一个字符推出来的
            for (int j = 0; j <= m; j++){
                //空正则串
                if (j == 0){
                    //判断主串是否为空，主串为空则true，不空则false（因为正则串空，无法匹配直接false）
                    //44dp[0][0]=true;其余为false
                    //空正则可以匹配空串，不可以匹配非空串，这里不需要多进行判断，因为两个串的长度一开始都取到了
                    //如果都不为空，那么之后就会走下面的判断，因为f[0][0]为true所以只要都不是空那么就只需要考虑是否匹配了
                    f[i][j] = i == 0;
                }else {
                    //正则串的最后一个是否是*
                    if (p.charAt(j - 1) != '*'){
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')){
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }else {
                        //这里直接不看ij是否匹配了，默认j-2不等于i-1然后给f[i][j]赋值
                        if (j >= 2){
                            //可用可不用，因为dp矩阵初始化默认为false，本质上和=一样
                            f[i][j] |= f[i][j-2];
                        }
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')){
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(a.charAt(2));
    }
}
