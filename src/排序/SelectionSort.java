package 排序;

/*选择排序 是表现最稳定的排序算法之一 ，因为无论什么数据进去都是O(n2)的时间复杂度 ，所以用到它的时候，数据规模越小越好。
唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。

选择排序(Selection-sort) 是一种简单直观的排序算法。
它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
然后再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
*/
public class SelectionSort {
    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        // 循环不变量：[0, i) 有序，且该区间里所有元素就是最终排定的样子
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            for(int j = i; j < array.length; j++){
                //找到最小的数
                if(array[j] < array[minIndex]){
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return  array;
    }
}
