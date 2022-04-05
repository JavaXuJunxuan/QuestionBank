package 二分查找;

import java.util.Arrays;

/**
 * 275. H 指数 II
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
 * 提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 * h高引用的条件就是，最后返回的h是论文数量，所以数组中length - h就是左边不符合高引用的论文数，length - h + 1下标位置的论文引用数
 * 最少要大于h（返回的论文数）
 */

public class Q275One {
    public int hIndex(int[] citations) {
        int length = citations.length;
        Arrays.sort(citations);
        if (citations[length - 1] == 0) {
            return 0;
        }
        int left = 0, right = length - 1;
        while (left < right){
            int mid = (right - left)/2 + left;
//            数组中的值等于h指数，同时h指数和高引用论文数量相等，返回的h值数必须论文数=全部输出的论文的引用数
//            所以当引用次数小于论文数的时候，要往右移，这样引用次数才会增加，论文数才会减小
            if (citations[mid] < length - mid){
                left = mid + 1;
            }else {
                right = mid;
            }
         }
        return length - left;
    }
}
