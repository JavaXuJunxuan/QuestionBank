package 排序;

/*冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，
一次比较两个元素，如果它们的顺序错误就把它们交换过来。
走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。*/
public class BubbleSort {
    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        for(int i = 0; i < array.length; i++){
            //比较到倒数第二个元素就可以了，因为每轮比较都是当前遍历元素和其下一个元素进行比较
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j + 1] < array[j]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
