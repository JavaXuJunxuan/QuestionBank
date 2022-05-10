package 暴力解法;

public class Q21Two {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        哑结点用于最后返回头结点
        ListNode prehead = new ListNode(-1);
//        定义一个指针来不断更新链表
        ListNode prev = prehead;
//        该循环知道迭代的其中一个链表为空为止
        while(list1!=null && list2!=null){
//            链表1的节点值小于链表2的节点值时，将指针指向链表1此时的节点下标：
            /*更新指针即为更新链表，因为指针指向的此时较小链表节点的前驱节点（引用指向的是节点地址），
            而下面的代码prev.next是链表节点的属性是存储在堆中的，更新next即为更新链表*/
            if (list1.val<list2.val){
                prev.next=list1;
                list1=list1.next;
            }else {
                prev.next=list2;
                list2=list2.next;
            }
//            每次执行完一次更新之后都将指针向后移动一位
            prev=prev.next;
        }
//        如果list1==null则prev.next=list2否则=list1
        prev.next=list1==null?list2:list1;
//        prehead是哑结点指向的是头结点的前驱节点
        return prehead.next;
    }
}
