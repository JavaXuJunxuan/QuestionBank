package 暴力解法;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */

public class Q160One {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != null){
            while (pb != null){
                if (pa == pb){
                    return pb;
                }
                pb = pb.next;
            }
            pb = headB;
            pa = pa.next;
        }
        return null;
    }
}
