package 双指针;

import 暴力解法使用额外空间.Q19One;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 此为快慢指针的变形，可以说是先后指针，通过两个指针之间的差值为固定值进行求解，用于求
 * 有关倒数的题
 */

public class Q19Two {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
//        因为要删除的是倒数第n个节点，如果second也=head的话最后second正好指向
//        要删除的节点，删除操作较难，如果=dummy则指向的是前驱节点
        ListNode second = dummy;
        for (int i=0;i<n;i++){
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        ListNode answer = dummy.next;
        return answer;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
