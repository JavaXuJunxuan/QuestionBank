package 滑动窗口;

import java.util.*;

/**
 *  3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 */

public class Q3One {
    public int lengthOfLongestSubstring1(String s) {
//        定义一个哈希集合，用来存储每个不重复的字符
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
//        rk是右指针不断向右读取集合中不重复的数组，初始值-1代表在集合的左边界的左侧
        int rk = -1,ans = 0;
        for(int i =0;i<n;i++){
//            只要下面的while循环退出了就执行这段代码，表示不断递增的枚举子串的起始位置
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (rk+1 < n && !set.contains(s.charAt(rk+1))){
//                这里的rk+1等于下面rk++后rk的值，这个循环的作用是不断向右移动右指针
                set.add(s.charAt(rk+1));
                rk++;
            }
//            rk-i表示他们之间差多少个字符，加1才表示从i到rk一共多少个字符
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++){
            if (map.containsKey(s.charAt(end))){
                int value = map.get(s.charAt(end)) + 1;
                map.replace(s.charAt(end),value);
            }else {
                map.put(s.charAt(end),1);
            }
            if (end - start + 1 == map.size()){
                result = Math.max(result,end - start + 1);
            }
            while (end - start + 1 > map.size()){
                char headkey = map.keySet().iterator().next();
                int count = map.get(headkey) - 1;
//                这里是移除每次超过窗口长度的第一个元素
                map.remove(headkey);
                map.put(headkey,count);
                if (map.get(headkey) == 0)map.remove(headkey);
                start++;
            }
        }
        return result;
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int length = 0, max = 0, start = 0;
        for (int end = 0; end < s.length(); end++){
            if (!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                length = end - start + 1;
                max = Math.max(max,length);
            }else {
                while (s.charAt(end) != s.charAt(start)){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwab";
        Q3One q3One = new Q3One();
        int  a = q3One.lengthOfLongestSubstring(s);
        System.out.println(a);
    }

}

