package 暴力解法使用额外空间;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 此为暴力解法由于链表没有下标于是采用将链表元素放入一个数组，因为数组有下标
 */

public class Q876Two {
    public static ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode cur = head;
        cur = cur.next;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        while (k < n / 2) {
            ++k;
//            这里为什么还能用head？
//            因为13行代码head把自己的地址赋给cur，
//            然后17行代码改变的是栈中cur这个引用存的内存地址，改变的不是
//            堆中head这个对象的属性
//            所以head的内存地址始终指向头结点
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode[] listNodes = {listNode1, listNode2, listNode3, listNode4, listNode5};
        System.out.println(middleNode(listNode1));
        ;
    }

    static class ListNode {
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

        @Override
        public String toString() {
            return "val=" + val + "next=" + next;
        }
    }
}

