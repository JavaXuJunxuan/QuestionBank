package 字符串;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 这里是用java自带的高精度运算
 */
public class Q67One {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a,2) + Integer.parseInt(b,2)
        );
    }
}
