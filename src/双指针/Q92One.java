package 双指针;

public class Q92One {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //定义一个虚拟头结点，这样就不用管头结点的事了
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //g是前节点
        ListNode g = dummyHead;
        //p可以看做是当前正在处理的节点
        ListNode p = dummyHead.next;
        //然后我们遍历链表，找到第一个要反转的节点
        for(int step = 0; step < left - 1; step++){
            g = g.next;
            p = p.next;
        }
        //这里p就不变了，一直是要反转左区间第一个节点的前一个节点
        for(int i = 0; i < right - left; i++){
            //每次都修改左区间的第一个节点，相当于一种头插法，顺序遍历反转链表区间然后取出遍历的元素头插法插入反转区间
            //这里先修改的节点一定要把它的下一个节点保存起来，因为是单向的，一旦一改不保存就找不到这个节点了，因为没有指针指向它了
            //链表想修改一个节点a的下一个节点b，首先就需要找到你要修改的下一个节点b的位置，这时候就需要找它b上一个节点c的位置然后next
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
}
