package 分治算法;

public class J17_1One {
    int[] res;
    //n这里没有进行赋值，但其代表题目传入的参数n即n位十进制数
    //start表示该数字当前左边界，这个左边界意思是指当前数字最高位对应的char数组下标。如n=2时，1~9左边界为1，10~99左边界为0
    //nine表示当前数字中出现了多少个9，如果出现1个9，左边界就要向左移1位。例如第1次出现“9”是在9这个数字出现的时候，此时nine++变为1，
    //进入下次递归n=2且nine=1时，start如果也=1，那么此时start就要-1，来左移左边界，以便统计二位数字
    int start, n;
    int nine = 0, count = 0;
    //num最后存的就是每十位进制数的字符串如1-9，10-99
    char[] num;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10,n) - 1];
        //num数组用来表示字符串的，数字的位数=数组大小，比如n等于2，则num数组为['0''0']、['0''1']、['0''2']...后边是将它转为字符串并按照左边界的位置进行截取的
        num = new char[n]; // 定义长度为 n 的字符列表
        //最开始的左边界是从n-1开始的，因为char数组的下标是从0开始，最末一位为n-1
        start = n - 1;
        //从num数组的第0位开始全排列递归
        dfs(0);
        return res;
    }
    //这里就进行循环调用了，每次固定一个位置，看这个位置后面是否还有值，有值就加入字符串中
    void dfs(int x) {
        //结束条件：当前x的下标越过char数组的最后一位下标n-1，此时记录结果
        if(x == n) {
            //从start左边界出开始截取字符串，这样就可以除去个位数开头的0了如"01"截取后就是"1"
            String s = String.valueOf(num).substring(start);
            //防止将"0"、"00"、"000"加进来
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            //n减去start等于nine，表示要进位了，进位就是将左边界start左移一位，即-14
            if(n - start == nine) start--;
            return;
        }
        //给char数组第x位添加数字，添加完后进入下一位
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;   //回溯
    }
    class Solution {
        int[] res;
        //start表示该数字当前左边界，这个左边界意思是指当前数字最高位对应的char数组下标。如n=2时，1~9左边界为1，10~99左边界为0
        //nine表示当前数字中出现了多少个9，如果出现1个9，左边界就要向左移1位。例如第1次出现“9”是在9这个数字出现的时候，此时nine++变为1，
        //进入下次递归n为2，nine为1，start为1，此时start就要-1，以便统计二位数字
        int nine = 0, count = 0, start, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public int[] printNumbers(int n) {
            this.n = n;
            //用来保存最终数字结果的
            res = new int[(int)Math.pow(10, n) - 1];
            //num数组用来表示字符串，比如n等于2，则num数组为['0''0']、['0''1']、['0''2']...后边是将它转为字符串并按照左边界的位置进行截取的
            num = new char[n];
            start = n - 1;  //最开始的左边界是从n-1，开始的，因为char数组的下标是从0开始，最末一位为n-1
            dfs(0);   //从char数组的第0位开始
            return res;
        }
        void dfs(int x) {
            //结束条件：当前x的下标越过char数组的最后一位下标n-1，此时记录结果
            if(x == n) {
                //从start开始截取字符串，如"01"截取后就是"1"
                String s = String.valueOf(num).substring(start);
                //防止将"0"、"00"、"000"加进来
                if(!s.equals("0")) res[count++] = Integer.parseInt(s);
                //n减去start等于nine，表示要进位了，进位就是将左边界start左移一位，即-1，
                // 这里start初始值为n-1，start是越来越小，nine会越来越大
                if(n - start == nine) start--;
                return;
            }
            //给char数组第x位添加数字，添加完后进入下一位
            for(char i : loop) {
                if(i == '9') nine++;
                num[x] = i;
                dfs(x + 1);
            }
            //每递归完一组都需要回溯，比如10-19完需要回溯，因为还要递归20-29，只有在99到100才需要进位这里90出现一个9，99出现第二个九
            //每轮开始其实nine都是0，只有在需要进位时这个nine才有用比如9，99，999，如果0-9虽然+1了并且进位但是for执行完就-1了
            //到下一个19会+1然后不会发生进位，出for循环再-1.
            nine--;   //回溯
        }
    }

    public static void main(String[] args) {
        String a = "123";
        System.out.println(a.substring(1,2));
    }
}
