package 双指针;

import java.util.List;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */

public class Q61One {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 计算有效的 k 值：对于与链表长度成整数倍的「旋转」都是没有意义的（旋转前后链表不变）
        int total = 0;
        ListNode tmp = head;
//        这里是短路与，如果前面的不成立就直接跳出循环
        while (tmp != null && ++total > 0) tmp = tmp.next;
        k %= total;
        if (k == 0) return head;
//        定义快慢指针，slow最终指向新链表的尾结点，
        ListNode slow = head, fast = head;
//        fast移动k个下标
        while (k-- > 0){
            fast = fast.next;
        }
//        因为最开始快慢指针都指向头结点，但上面fast已经移动过偏移量了，新的头结点在原来链表的倒数第k个节点
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 保存新头结点，并将新尾结点的 next 指针置空
        ListNode nHead = slow.next;
        slow.next = null;
        fast.next = head;
        return nHead;
    }
}
