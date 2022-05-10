package 双指针;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 此为快慢指针解法
 */

public class Q876Three {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head , fast = head;
//        为什么这里是fast.next!=null，因为题目要求如果有两个中间节点取第二个，这种情况为链表有偶数个节点时
//        因为fast都是奇数，所以遍历到最后时fast后还有一个节点，此时slow节点指向的是第一个中间节点，需要再往
//        后移动一下所以fast.next！=null即可此时fast执行完循环体后为null；
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

