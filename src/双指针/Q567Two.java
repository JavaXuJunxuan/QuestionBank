package 双指针;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 这道题考的是排列是子串，所以只要s1中的字符个数等于s2中一个子串的字符个数即可
 * 双指针解法
 */

public class Q567Two {
    public boolean checkInclusion(String s1, String s2) {
        int n =s1.length(),m=s2.length();
        if (n>m){
            return false;
        }
        int[] count = new int[26];
        for (int i =0;i<n;i++){
            --count[s1.charAt(i)-'a'];
        }
        int left=0;
//        这个循环的目的是让因为上面那个循环导致的数组中元素组增大到0，如果增大多了>0了则会进入下
//        while循环
        for (int right=0;right<m;right++){
            int x = s2.charAt(right)-'a';
            ++count[x];
//            为什么当count[x]>0时就要向右移动左指针？
//            因为count[x]>0表示[left，right]这个区间中对应的字符多了，需要左指针向有移动来减少
//            这个字符进而使count[x]<0
            while (count[x]>0){
                --count[s2.charAt(left)-'a'];
                left++;
            }
          /*  注意到[left,right]的长度每增加1,count的元素值之和就增加1。当[left,right]
              的长度恰好为n时，就意味着count的元素值之和为0。由于count的值不为正，元素值之
              和为0就意味着所有元素均为0，这样我们就找到了一个目标子串。*/
            if (right-left+1==n){
                return true;
            }
        }
        return false;
    }
}
