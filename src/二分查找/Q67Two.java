package 二分查找;

/**
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */

public class Q67Two {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
//        一个数的平方根没有自己的一般大，处理1,0所以上面特殊判断一下
        int l = 0 , r = x/2 ;
        while (l < r){
//            这里不能用+1因为当取值为int最大值时会出现数据溢出变成负值
//            这道题也不能用中值小+左那个区间，因为最后求的平方根整数可能会是浮点数然后去掉小数部分，为向下取整，
//            中值小+左区间会发生left=mid+1向上取整
            int mid = l + (r - l + 1)/2;
            if ((long)mid * mid > x){
                r = mid - 1;
            }else {
                l = mid;
            }
        }
        return l;
    }
}
