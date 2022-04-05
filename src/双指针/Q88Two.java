package 双指针;

/**
 * 88. 合并两个有序数组
 * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组nums1中。为了应对这种情况，
 *      nums1的初始长度为m+n，其中前m个元素表示应合并的元素，后n个元素为0，应忽略。nums2的长度为 n 。
 */

public class Q88Two {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//         分别给两个数组定义一个指针，通过这个指针不断遍历两个数组
        int p1 = 0,p2 = 0;
//        定义一个新数组来储存排序后两个数组的元素
        int[] sorted = new int[m+n];
//        定义一个变量来保存当前遍历的数组元素
        int cur;
//        把两个数组都要完全遍历完
//        下面的操作中只要取出一个数组元素后，都要把数组下标+1来方便下一次的遍历
        while(p1 < m || p2 < n){
//            如果此时p1=m则代表nums1数组已经遍历完，此时只需要遍历nums2数组
            if (p1 == m){
                cur = nums2[p2++];
//            如果此时p2=n则代表nums2数组已经遍历完，此时只需要遍历nums1数组
            }else if (p2 == n){
                cur = nums1[p1++];
//                执行下面两个循环的条件是两个数组都没有遍历完
//                目的是为了取出两个数组中更小的那个元素
            }else if (nums1[p1] < nums2[p2]){
                cur = nums1[p1++];
            }else {
                cur = nums2[p2++];
            }
//            因为上面取出元素后都进行了自加1操作，所以下面需要把这个1去掉
            sorted[p1+p2-1] = cur;
        }
//        题目不要求返回新数组，只要把nums1中储存好整理好后的数组元素即可
        for(int i = 0;i < m + n;i++){
            nums1[i] = sorted[i];
        }
    }
}
