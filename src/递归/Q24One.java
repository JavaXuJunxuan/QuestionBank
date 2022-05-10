package 递归;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

public class Q24One {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
//        递归时每次传入的都是每两个节点中的第一个节点，然后返回的是后一个节点
//        这个递归方法体主要就是13,17，18三行代码：还有10终止条件，19返回值
//        因为方法传入得是每两个节点的第一个节点，所以13行代码是取到后一个节点，然后给这两个节点分别处理
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
