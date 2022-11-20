package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

public class J06_1One {
    List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
       recur(head);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            ints[i] = list.get(i);
        }
        return ints;
    }
    void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        list.add(head.val);
    }
//    递归法2
    int num = 0 , i = 0;
    int[] ints;
    public int[] reversePrint1(ListNode head) {
        huisu(head);
        return ints;
    }
    void huisu(ListNode listNode){
        if (listNode == null){
            ints = new int[num];
            return;
        }
        num++;
        huisu(listNode.next);
        ints[i++] = listNode.val;
    }
}
