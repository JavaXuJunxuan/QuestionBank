package 滑动窗口;

import java.rmi.dgc.Lease;
import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */

public class Q438One {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLength = s.length();
        int plength = p.length();
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for(int i = 0; i < plength; i++){
            pCnt[p.charAt(i) - 'a']++;
        }
        int start = 0;
        for (int end = 0; end < sLength; end++){
            int curEnd = s.charAt(end) - 'a';
            sCnt[curEnd]++;
//            下面的顺序不能改，因为每次想右边遍历，都有可能导致遍历的那个元素的下标得值大于目标字符串对应元素下标得值，所以需要
//            移动左指针使下面的条件符合，然后判断这次移动后的元素是否是异位词
            while (sCnt[curEnd] > pCnt[curEnd]){
                int curStart = s.charAt(start) - 'a';
                sCnt[curStart]--;
                start++;
            }
            if (end - start + 1 == plength){
                list.add(start);
            }
        }
        return list;
    }
}
