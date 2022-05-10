package 递归;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

public class Q206Two {
//    ret始终是最后一个节点即尾结点
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
