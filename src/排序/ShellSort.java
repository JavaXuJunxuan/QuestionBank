package 排序;
/*希尔排序是希尔（Donald Shell） 于1959年提出的一种排序算法。
希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；
随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
*/
public class ShellSort {
    /**
     * 希尔排序
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        //定义 ，初始化增量gap
        int current, gap = len / 2, preIndex;
        //进行log2len次循环
        //循环不变量为[0,i + gap);那么初始时循环不变量中有一个元素，因为插入排序所以有下标为0的元素循环不变量中有序也成立
        //每次要排定的元素是i+gap位置的元素
        //最后一次循环要排定的元素时len - 1 - gap + gap = len - 1，那么排完这个元素之后下次循环前[0,len - 1]就是有序的
        //退出循环正好数组有序
        while(gap > 0){
            //从增量开始遍历，每一个增量都为一个分组
            //希尔排序就是这里和插入排序不一样，因为插入排序判断元素大小的间隔为1，而希尔排序间隔为gap,所以退出循环条件不一样
            for(int i = 0; i < len - gap; i++){
                //把当前遍历的元素保存起来
                current = array[i + gap];
                //这样每次都可以保证gap个元素一个分组
                preIndex = i;
                while(preIndex >= 0 && array[preIndex] > current){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return array;
    }
}
