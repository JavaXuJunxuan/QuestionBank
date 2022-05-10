package 暴力解法;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 此为暴力解法遍历链表得到链表长度，然后计算l-n+1的节点并删除
 */

public class Q19One {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        链表中常需要一个哑节点dummy node指向链表的头节点
        ListNode dummy = new ListNode(0,head);
        int length = getListLength(head);
//        指定一个临时节点也指向头节点
        ListNode current = dummy;
//        遍历这个头节点并把节点向后移直到移动到要删除的节点位置
        for (int i =1;i<length-n+1;i++){
            current = current.next;
        }
//        删除这个节点就是让前驱节点的next指向他的后继节点，这里改变的是堆里面链表里这个节点里面的属性的值
//        所以指向这个链表的所有引用，都删除了这个节点
        current.next=current.next.next;
//        然后返回头节点
        ListNode answer = dummy.next;
        return answer;
    }

    public int getListLength(ListNode listNode){
        int n = 0;
        while (listNode!=null){
            n++;
            listNode=listNode.next;
        }
        return n;
    }
    class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
