package 栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

public class J06_1Three {
    public int[] reversePrint(ListNode head) {
        /*LinkedList<Integer> stack = new LinkedList<>();
        while (head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = stack.removeLast();
        }
        return res;*/
        Stack<Integer> stack = new Stack();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = stack.pop();
        }
        return res;
    }
}


