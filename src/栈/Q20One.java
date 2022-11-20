package 栈;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */

public class Q20One {
    public static boolean isValid1(String s) {
//        n是字符串的长度
        int n = s.length();
//        if用来判断字符串中是否是偶数个字符
        if (n%2==1){
            return false;
        }
//        创建一个Map集合用来存储括号类型
        Map<Character,Character> pairs = new HashMap<Character,Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
//        利用栈的数据结构来判断括号类型是否正确
        Deque<Character> stack = new LinkedList<Character>();
        for (int i =0;i<n;i++){
//            这一步取出的字符是字符串中的字符
            char ch = s.charAt(i);
//            if判断的是pairs集合中是否存在右括号，为true表示取出的字符串ch为右括号，为false表示取出的字符串为左括号
            if (pairs.containsKey(ch)){
//                取出右括号后进入下面这个if判断：
//                栈为空表示这个右括号前面没有对应的左括号,所以直接返回false
//                栈顶元素不等于这个右括号的值(对应的左括号)也表示不符合要求
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
//                执行到此处说明取出的右括号在栈中有对应的左括号,这时要把匹配过的左括号出栈
                stack.pop();
//                pop压入栈的都是左括号
            }else {
                stack.push(ch);
            }
        }
//        执行到此处表示遍历完了字符串且正常结束,为什么还要判断isEmpty?
//        因为最后可能出现偶数个左括号这时也能正常遍历完字符串,所以需要判断
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid1(s));;
    }
    public static boolean isValid2(String s) {
        int length = s.length();
        if (length % 2 != 0) return false;
        if (length == 0) return true;
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else if (stack.empty() || c != stack.pop()){
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
