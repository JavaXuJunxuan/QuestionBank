import java.util.Random;

public class Sort {
    /*选择排序利用了贪心算法的思想，每次都给当前遍历的元素找到一个最优的也就是最小的，然后把最小的换过来，直到每个位置都换一遍
    public int[] selectSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[index] > nums[j]){
                    index = j;
                }
            }
            swap(nums, i, index);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/

    /*public int[] insertSortArray(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = nums[i];
        }
        return nums;
    }*/

    /*private static final int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums,0,len - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERTION_SORT_THRESHOLD){
            insert(nums,left,right);
        }
        int mid = (right + left) >>> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid +1, right, temp);
        if (nums[mid] <= nums[mid + 1]){
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums,left,temp,left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if (i == mid + 1){
                nums[k] = nums[j];
                j++;
            }else if (j == right + 1){
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

    private void insert(int[] nums, int left, int right) {
        for (int i = left + 1; i < right; i++){
            int j = i;
            while (j > left && nums[j] < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = nums[i];
        }
    }*/

    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums){
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD){
            insert(nums,left,right);
            return;
        }
        int pindex = partition(nums, left, right);
        quickSort(nums, left, pindex - 1);
        quickSort(nums, pindex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true){
            while (lt <= right && nums[lt] < pivot){
                lt++;
            }
            while (gt > left && nums[gt] > pivot){
                gt--;
            }
            if (lt >= gt){
                break;
            }
            swap(nums,lt,gt);
            lt++;
            gt--;
        }
        swap(nums,left,gt);
        return gt;
    }

    private void insert(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++){
            int j = i;
            while (j > left && nums[j-1] > nums[j]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = nums[i];
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
