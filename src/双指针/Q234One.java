package 双指针;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

public class Q234One {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            pre.next = prepre;
            prepre = pre;
            slow = slow.next;
            fast = fast.next.next;
        }
//        进入下面循环的情况为链表节点为奇数个，因为每次fast的下标都为奇数，所以奇数节点退出循环时fast在最后一个节点上，此时slow
//        少移动一位这里进行补上
        if (fast != null){
            slow = slow.next;
        }
//        下面可以只判断一个为空情况，因为奇数节点pre=slow，偶数节点pre和slow分别为两个中间节点
        while (pre != null && slow != null){
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Q234One q234One = new Q234One();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        q234One.isPalindrome(a);
    }
}
