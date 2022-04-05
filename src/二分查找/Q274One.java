package 二分查找;

/**
 * 274. H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数”，一名科研人员的 h指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 这道题的mid找的值和275不一样，这道题的mid是找的论文的数，因为最后返回的是论文篇数
 */
public class Q274One {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0, right = length - 1;
        while (left < right){
            int count = 0;
//            mid是论文篇数，看看数组中是否有多少个论文引用数>=mid的论文，count就是符合前面要求的论文总数
//            因为高引用h一个大前提就是：论文引用次数>=论文数=h
            int mid = (right - left)/2 + left;
            for (int citation : citations){
                if (citation > mid){
                    count++;
                }
            }
//            这里的count就是论文引用数大于等于上面mid所算出来的论文篇数的论文数
//            如果实际上大于等于的小于二分算出来的，那么说明实际的高引用论文不够，需要减少h也就是论文数左移
            if (count < mid){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
