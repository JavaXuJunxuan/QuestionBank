package 位运算;

public class J15_1One {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0){
                res += n & 1;
                n >>>= 1;
        }
        return n;
    }
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0){
            res++;
            n &= (n - 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int b = 1;
        System.out.println(b);
        b = b << 1;
        System.out.println(b);
       /* b = b >> 1;
        System.out.println(b);*/
        b = b >>> 1;
        System.out.println(b);
    }
}
