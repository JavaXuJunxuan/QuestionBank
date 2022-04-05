package 递归;

/**
 *  21. 合并两个有序链表
 *  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

public class Q21One {
    static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        首先判断两个链表是不是为空，为空直接返回非空链表即可
        if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
//            如果链表1的头节点值比链表2的头结点值小，则递归调用此方法来为链表1的头结点的后继节点找对应节点
//            当链表1的节点小于链表2的节点时，假设此时有一个指针，指针此时指向list1.next此时后续代码与list1无关了
//            只与list1.next有关
//            下面的每次比较都会把比较的两个节点值中节点值娇小的那个节点取出来然后
        }else if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
//            与上面那个正好相反，知道遍历完一个链表，假设list2,.next为空则会把list1赋给list2,.next知道最后回到最初方法体
        }else {
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}

