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
//      题目要求不重复的子串，涉及到不重复，不同等问题，我们要采用不含重复元素的集合，Map或者Set两者均可，但使用Map的效率比较低
//      因为还要维护Map的value，所以我们使用Set集合
        Set<Character> set = new HashSet();
//      初始化答案变量，过程变量，以及左指针
        int maxResult = 0,length = 0, start = 0;
//      遍历目标区间，右指针每次循环都会向右扩张，进而达到搜索最优解的目的
//      每次循环开始时窗口内都一定是符合题目要求的，这道题就是窗口内没有重复元素
        for (int end = 0; end < s.length(); end++){
//          因为此题要求不重复子串，Set集合具有不重复性，所以Set集合中没有当前遍历到的元素就说明窗口中没有当前元素
            if (!set.contains(s.charAt(end))){
//                因为题目要求最长的不含重复字符的子串，所以只有遍历到不重复元素时才会判断最大子串的长度
                set.add(s.charAt(end));
                length = end - start + 1;
                maxResult = Math.max(maxResult,length);
//          当遍历到重复元素时，这个窗口就不符合题目要求了，此时就需要移动窗口（左指针收缩窗口），直到其满足题目要求（不含重复字符）
            }else {
//              当当前左指针元素不等于当前遍历的右指针元素时表明重复元素在左指针和右指针之间，此时要找到那个重复的元素，找到了就退出循环
                while (s.charAt(end) != s.charAt(start)){
                    set.remove(s.charAt(start));
                    start++;
                }
//              然后左指针再右移一位来剔除重复元素，进入下一次循环
                start++;
            }
        }
        return maxResult;
    }

    public static void main(String[] args) {
        String s = "pwwab";
        Q3One q3One = new Q3One();
        int  a = q3One.lengthOfLongestSubstring(s);
        System.out.println(a);
    }
}

