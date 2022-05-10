package 双指针;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

public class Q206One {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head.next;
        ListNode sec = new ListNode();
        head.next = null;
        while (prev != null){
            sec = prev.next;
            prev.next = head;
            head = prev;
            prev = sec;
        }
        return head;
    }
}
