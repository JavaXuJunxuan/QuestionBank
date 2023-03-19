package 排序;

public class Sort {
    public static void main(String[] args) {
        int[] ints = {5,8,9,1,74,7,2,6,9};
        Sort sort = new Sort();
        sort.sortArray(ints);
    }

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        mergeSort(nums, 0, length - 1, temp);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right, int[] temp){
        if(right - left < 7){
            insertion(nums,left,right);
            return;
        }
        int mid = (left + right) >>> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if(nums[mid] <= nums[mid + 1]){
            return;
        }
        merge(nums, left, mid, right, temp);
    }
    private void insertion(int[] nums, int left, int right){
        int current, next;
        for(int i = left; i < right; i++){
            current = i;
            next = nums[i + 1];
            while(current >= 0 && next < nums[current]){
                nums[current + 1] = nums[current];
                current--;
            }
            nums[current + 1] = next;
        }
    }
    private void merge(int[] nums, int left, int mid, int right, int[] temp){
        for(int i = left; i <= right; i++){
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if(j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i] > temp[j]){
                nums[k] = temp[j];
                j++;
            }else{
                nums[k] = temp[i];
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
