package 动态规划;

/*剑指 Offer 10- I. 斐波那契数列
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。*/

public class J10_1_1One {
        public int fib(int n) {
            //a，b即为动态规划的两个初始状态，sum为其返回值
            int a = 0, b = 1, sum;
            //从0开始的目的是因为如果求的是0或者1的斐波那契，我们仍不需要额外的判断，因为如果是0则不会进入循环；是1则返回ab都对
            //但造成的结果就是我们会多计算一次（n=1这一次）。一共进行n次计算，但最后一次计算是多余的，所以最后我们需要返回a，因为b的结果是最后一次多余计算的结果
            for(int i = 0; i < n; i++){
                //对结果求余，防止溢出
                sum = (a + b) % 1000000007;
                //下面进行递推两个初始值
                a = b;
                b = sum;
            }
            return a;
        }
}
