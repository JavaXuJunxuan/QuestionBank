package 滑动窗口;

import java.rmi.dgc.Lease;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */

public class Q438One {
    public List<Integer> findAnagrams1(String s, String p) {
//        因为要找所有的异位词子串的起始下标所以使用list集合
        List<Integer> list = new ArrayList<>();
        int sLength = s.length();
        int plength = p.length();
        int[] sInt = new int[26];
        int[] pInt = new int[26];
        for(int i = 0; i < plength; i++){
            pInt[p.charAt(i) - 'a']++;
        }
        int start = 0;
//      循环每次开始时窗口区间的长度一定小于等于答案字符串的长度
        for (int end = 0; end < sLength; end++){
            int curEnd = s.charAt(end) - 'a';
            sInt[curEnd]++;
//          下面的顺序不能改，因为每次向右边遍历，都有可能导致遍历的那个元素的下标得值大于目标字符串对应元素下标得值，所以需要
//          移动左指针使下面的条件符合，然后判断这次移动后的元素是否是异位词
//          判断当前遍历字符的字符数是否和答案字符的字符数相等，不等就代表一定不是答案，所以右移左指针
            while (sInt[curEnd] > pInt[curEnd]){
                int curStart = s.charAt(start) - 'a';
                sInt[curStart]--;
                start++;
            }
//          长度相等就代表找到了答案，因为长度相等时一定有字符数都相等
            if (end - start + 1 == plength){
                list.add(start);
            }
        }
        return list;
    }
    public List<Integer> findAnagrams(String s, String p) {
//        因为要找所有的异位词子串的起始下标所以使用list集合
        List<Integer> list = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for(int i = 0; i < pLength; i++){
            pCnt[p.charAt(i) - 'a']++;
        }
        int start = 0;
        for (int end = 0; end < sLength; end++){

            sCnt[s.charAt(end) - 'a']++;
//            下面的顺序不能改，因为每次向右边遍历，都有可能导致遍历的那个元素的下标得值大于目标字符串对应元素下标得值，所以需要
//            移动左指针使下面的条件符合，然后判断这次移动后的元素是否是异位词
            while (end - start + 1 > pLength){
                sCnt[s.charAt(start) - 'a']--;
                start++;
            }
            if (end - start + 1 == pLength){
                if (Arrays.equals(sCnt,pCnt)) {
                    list.add(start);
                }
            }
        }
        return list;
    }
}
