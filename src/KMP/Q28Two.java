package KMP;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 这里用的是KMP算法，KMP算法是一个快速查找匹配串的算法，它的作用其实就是本题问题：如何快速在「原字符串」中找到「匹配字符串」。
 */

public class Q28Two {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
//        取出两个字符串的长度
        int n = haystack.length(),m = needle.length();
//        原串和匹配串前面都加空格，使其下标从 1 开始
        haystack=" "+haystack;
        needle=" "+needle;
//        把两个字符串变成两个字符数组进行遍历，这样可以不用charAt方法
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
//        构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）因为前面匹配串加了一个哨兵
        int[] next = new int[m+1];
//        构造过程 i = 2，j = 0 开始，i小于等于匹配串长度，因为字符串前有哨兵（下标为0）i为后缀指针为2，j是前缀指针
//        i前缀指针永远比j后缀指针大1，这样才能保证一个是前缀一个是后缀
        for (int i = 2,j = 0;i<=m;i++){
//            为什么下面都是j+1而不直接设置j=1？
//            因为最前面加了一个哨兵（空格）这个不需要比较所以j第一次匹配时需要加1
//        匹配不成功：当一直匹配不上时会一直将j前缀指针左移直到j=o退出循环
            while (j > 0 && need[i] != need[j+1])
//                因为上面比较的是j+1的下标位置不匹配，所以j前缀指针此时只需要回到next数组中j下标位置的值即可
//                且j在next数组对应的下标一直比匹配串的下标小1，因为next[哨兵]=0。然后匹配串第一个字符对应的next下标位置也是0
                j = next[j];
//        匹配成功：
            if (need[i] == need[j+1]) j++;
//          更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
//        匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
//        因为最前面有一个哨兵，所以需要从1开始
        for (int i = 1,j = 0; i<=n; i++){
            // 匹配不成功 j = next(j)
            while (j > 0 && hay[i] != need[j+1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (hay[i] == need[j+1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i-m;
        }
        return -1;
    }
}
