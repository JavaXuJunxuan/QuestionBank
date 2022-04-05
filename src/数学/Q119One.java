package 数学;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

public class Q119One {
    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0;i < rowIndex;i++){
            List<Integer> list = new ArrayList<Integer>();
            for (int j =0;j <= i;j++){
                if (j == 0 || j ==i){
                    list.add(1);
                }else {
                    list.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(list);
        }
        return ret.get(rowIndex-1);
    }
    public List<Integer> getRow2(int rowIndex) {
//        滚动数组进行优化
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
//       这个为杨辉三角第一行的那个1
        list.add(1);
//        这里的i表示层数
        for (int i  = 1;i <= rowIndex; i++){
//            每遍历一次都要在集合最后面加一个0，这个0代表每一层多的那个元素
//            其次，这个0是加在集合当前层的最后一个位置上，所以可以保证下一层的最后一个元素值等于上一层最后一个元素值（0）
            list.add(0);
//            这里的j表示每一层元素的下标，其中第一个1不会被修改，因为j>0
            for (int j = i;j > 0;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }
        }
        return list;
    }

}
