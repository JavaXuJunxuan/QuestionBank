package 链表;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 这道题可能要删除的节点包括头结点，所以可以设虚拟节点指向头结点，下面的解法没有使用Two使用了
 */

public class Q203One {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode pre = head;
        while (head.next != null){
            /*while (head.next.val == val){
                head.next = head.next.next;
                if (head.next == null)return pre;
            }
            head = head.next;*/
            if (head.next.val == val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return pre;
    }
}
