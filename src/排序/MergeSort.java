package 排序;

import java.util.Arrays;

/*和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，
因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
若将两个有序表合并成一个有序表，称为2-路归并。
*/
public class MergeSort {
    //列表大小等于或小于该大小，将优先于 mergeSort 使用插入排序
    private static final int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums){
        int length = nums.length;
        int[] temp = new int[length];
        mergeSort(nums, 0, length - 1, temp);
        return nums;
    }

    /**
     * 对数组 nums 的子区间 [left, right] 进行归并排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
     */
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if(right - left <= INSERTION_SORT_THRESHOLD){
            insertionSort(nums, left, right);
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if(nums[mid] <= nums[mid + 1]){
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 对数组 arr 的子区间 [left, right] 使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private static void insertionSort(int[] arr, int left, int right) {
        int current, nextIndex;
        for(int i = left; i < right; i++){
            current = i;
            nextIndex = arr[i + 1];
            while (nextIndex >= left && nextIndex < arr[current]){
                arr[current + 1] = arr[current];
                current--;
            }
            arr[current + 1] = nextIndex;
        }
    }

    /**
     * 合并两个有序数组：先把值复制到临时数组，再合并回去
     *
     * @param nums
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param temp  全局使用的临时数组
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums,left,temp,left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if(j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else {
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
