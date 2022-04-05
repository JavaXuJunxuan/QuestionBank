package 数学;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

public class Q118One {
    public List<List<Integer>> generate(int numRows) {
//        list集合中储存的是一个泛型为Integer类型的集合，也就是说list集合中的元素都是一个集合
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        往ret这个集合中填入元素
        for(int i =0;i < numRows;i++){
//            ret中每一个元素都是一个集合所以每次执行上面的for循环都要重新创建一个新的list集合出来
//            这个集合存储的是每一层杨辉三角的数值
            List<Integer> row = new ArrayList<Integer>();
//            杨辉三角中每行元素等于其行数，因为此处杨辉三角行数为i值+1，第一行为0行所以下面j<=i
            for (int j =0;j<=i;j++){
//                每一行第一个和最后一个数字总是为1
                if (j == 0 || j == i){
                    row.add(1);
                }else {
//                第n行的第i个数等于第n−1行的第i−1个数和第i个数之和
                    row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
//            每次往一行中添加完元素后就把这个集合存入杨辉三角集合对应的那个行数的下标对应的位置中
            ret.add(row);
        }
        return ret;
    }
}
