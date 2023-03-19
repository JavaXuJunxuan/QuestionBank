package 排序;

/**
 * @Author: Xjx
 * @Create: 2022/12/31 - 20:07
 */
public class HeapSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 首先将数组整理成堆（这里是整理成大根堆了）
        heapify(nums);
        //然后就可以从这个有序的堆中取出最值元素放入数组让数组变为有序数组了
        // 循环不变量：区间 [0, i] 堆有序，区间(i,length)数组有序，循环中的i是将要被处理进有序数组的元素
        //这里最后一个元素即i=0位置不需要处理，因为后面都已经排好顺序了只剩一个最小值元素了
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
        return nums;
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移，这个位置是倒数第二层最后一个元素，然后i--不断向前遍历整理前面的元素
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums
     * @param k    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int k, int end) {
        //看一下k节点即父节点有没有子节点，没有的话直接不进入循环了
        //循环中判断k位置元素的左右子元素是否比它大，如果有就找出最大的替换掉父元素即k
        while (2 * k + 1 <= end) {
            //j位置的元素就是两个子元素中较大的那个元素
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            //如果子元素中那个较大的元素比父元素还大就替换掉父元素
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                //如果子元素没有比父元素大直接跳出循环结束此次执行
                break;
            }
            //如果替换了就继续看替换后新子元素位置的左右子元素是否比它大，接着进入循环
            k = j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
