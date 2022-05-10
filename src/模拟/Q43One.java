package 模拟;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */

public class Q43One {
    public String multiply(String num1, String num2) {
        if (num1.equals(0) || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >=0; i--){
            for (int j = n - 1; j >= 0; j--){
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = num + res[p2];
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<res.length;i++){
            //这里的i==0是因为只可能出现首位为0的情况，例如一个三位数乘一个两位数不可能出现结果是一个三位数的情况。所以只需要判断首位即可。
            if(res[i]==0&&i==0){
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }
}
