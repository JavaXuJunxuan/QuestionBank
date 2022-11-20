package 位运算;

public class J16_1One {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0){
            x = 1/x;
            b = - b;
        }
        //这里一定是>0，因为我们想拿到最后的结果，指数一定会出现1，此时为奇数，我们才可以把结果乘到res中
        while (b > 0){
            //这里b是指数，如果n与1（二进制01）做与运算最后=1（01）表示其是个奇数，我们直接进行位运算会丢掉这个数，所以
            //如果它是奇数我们需要先把它那出来单独乘一遍
            //取余数n%2 等价于 判断二进制最右一位值 n&1；
            if ((b & 1) == 1) res *= x;
            //到这里我们就可以利用数学公式进行降幂处理了
            x *= x;
            //向下整除n//2等价于右移一位 n>>1 ；
            b >>= 1;
        }
        return res;
    }
}
