package 暴力解法使用额外空间;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 此为暴力解法由于链表没有下标于是采用将链表元素放入一个数组，因为数组有下标
 */

public class Q876One {
    //    这里传入的是一个链表节点
    public ListNode middleNode(ListNode head) {
//        创建一个存储链表节点的数组
        ListNode[] A = new ListNode[100];
//        i是这个数组的头下标
        int i = 0;
//        只要传入的链表节点不为空就进入循环体
        while (head != null) {
//            把这个非空的链表节点存入数组，然后i再自增
            A[i++] = head;
            head = head.next;
        }
//        这里不用向上取整的原因是20行代码最后i会加1，此时的i=数组的长度
        return A[i / 2];
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
