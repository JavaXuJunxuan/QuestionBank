package 二分查找;

/**
 * 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 * 这道题小于mid的数可能会有重复的，所以=mid值的元素在数组中可能有多个，所以第k小的数可能是mid，但是数组中mid值太多加起来的all就大于了
 * k，所以大于时第k小的数可能就是mid，所以right=mid
 */

public class Q378One {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length - 1;
        int left = matrix[0][0], right = matrix[length][length];
        while (left < right){
            int mid = (right - left)/2 + left;
            int all = search(mid,matrix);
            if (all < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    public int search(int mid, int[][] nums){
        int all = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            if (nums[i][length - 1] <= mid){
                all += length;
            }else {
                for (int j = 0; j < length; j++){
                    if (nums[i][j] <= mid){
                        all++;
                    }
                }
            }
        }
        return all;
    }
}
