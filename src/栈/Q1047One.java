package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */

public class Q1047One {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        char c;
        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != c){
                deque.push(c);
            }else {
                deque.pop();
            }
        }
        String str = "";
        while (!deque.isEmpty()){
            str = deque.pop() + str;
        }
        return str;
    }
}
