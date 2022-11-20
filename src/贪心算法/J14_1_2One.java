package 贪心算法;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class J14_1_2One {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }

    public static void main(String[] args) {
    }
}
